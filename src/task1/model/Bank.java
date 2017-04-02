package task1.model;

import java.util.ArrayList;

/**
 * Class simulates the work of the bank
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Bank {
    /**The list of all accounts*/
    private ArrayList<Account> listAccountsBank;// = new ArrayList<>();
    /**The list of all clients*/
    private ArrayList<Client> listClients;// = new ArrayList<>();

    public Bank(){
        listAccountsBank = new ArrayList<>();
        listClients = new ArrayList<>();
    }
    public void setListAccountsBank(ArrayList<Account> listAccountsBank) {
        this.listAccountsBank = listAccountsBank;
    }

    public ArrayList<Account> getListAccountsBank() {
        return listAccountsBank;
    }

    public ArrayList<Client> getListClients() {
        return listClients;
    }

    public void setListClients(ArrayList<Client> listClients) {
        this.listClients = listClients;
    }
}
