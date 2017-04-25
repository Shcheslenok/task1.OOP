package dao;

import model.beans.Account;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    private static JDBCConnectionPool connectionPool;

    public static JDBCConnectionPool getConnectionPool() {
        System.out.println("get Connection pool start");
        if (connectionPool == null) {
            Properties props = readProperties("jdbc.properties");
            connectionPool = new JDBCConnectionPool(
                    props.getProperty("jdbc.Driver"),
                    props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.user"),
                    props.getProperty("jdbc.password")
            );
        }

        return connectionPool;
    }

    private static Properties readProperties(String fileResourceName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = JDBCUtils.class.getClassLoader().getResourceAsStream(fileResourceName);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public static Collection<Account> getAccounts(Connection conn) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from accounts";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                String accountNumber = rs.getString("accountNumber");
                int amountMoney = Integer.parseInt(rs.getString("amountMoney"));
                boolean blocked = Boolean.valueOf(rs.getString("Blocked"));

                Account account = new Account();
                account.setAccountNumber(accountNumber);
                account.setAmountMoney(amountMoney);
                account.setBlocked(blocked);

                list.add(account);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void insertAccount(Connection conn, Account account) {
        String sql = "insert into accounts(accountNumber, amountMoney, Blocked) values (?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, account.getAccountNumber());
            pstm.setString(2, String.valueOf(account.getAmountMoney()));
            pstm.setString(3, String.valueOf(account.isBlocked()));

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
