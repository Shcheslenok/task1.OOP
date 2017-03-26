package task1.Model;

import java.util.ArrayList;

/**
 * Class simulates the work of the bank
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Bank {
    /**The list of all accounts*/
    private static ArrayList<Account> listAccountsBank = new ArrayList<>();
    /**The list of all clients*/
    private static ArrayList<Client> listClients = new ArrayList<>();

    public void setListAccountsBank(ArrayList<Account> listAccountsBank) {
        this.listAccountsBank = listAccountsBank;
    }

    public static ArrayList<Account> getListAccountsBank() {
        return listAccountsBank;
    }

    public static ArrayList<Client> getListClients() {
        return listClients;
    }

}
