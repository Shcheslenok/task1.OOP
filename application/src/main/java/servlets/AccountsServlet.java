package servlets;

import dao.JDBCUtils;
import model.beans.Account;
import model.beans.Bank;
import model.services.ServiceBank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static dao.JDBCUtils.getAccounts;

@WebServlet(urlPatterns = "/Accounts", loadOnStartup = 1)
public class AccountsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        request.setAttribute("accounts", getAccounts(conn));
        JDBCUtils.getConnectionPool().checkIn(conn);

        request.getRequestDispatcher("/accounts.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        String key = request.getParameter("key");

        if (!key.equals("count")){

        String sql = "UPDATE accounts SET Blocked = 'false' WHERE accountNumber = (?)";
        PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1 ,key);
                pstm.executeUpdate();

                response.getWriter().append("false");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            Collection<Account> list;
            list = getAccounts(conn);
            Bank bank = new Bank();
            bank.setListAccountsBank((ArrayList<Account>)list);
            String str = "All money: " + ServiceBank.countMoney(bank) + "; Positive balance: "
                    + ServiceBank.countPositiveBalance(bank) + "; Negative balance: "
                    + ServiceBank.countNegativeBalance(bank);
            response.getWriter().append(str);
        }

        response.getWriter().close();
    }
}
