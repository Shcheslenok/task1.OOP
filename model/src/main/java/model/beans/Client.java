package model.beans;

import java.util.ArrayList;

/**
 * Class contains data about client
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Client {
    /**The name of client*/
    private String name;
    /**The list of client account*/
    private ArrayList<Account> listAccountsClient;// = new ArrayList<>();

    public void setListAccountsClient(ArrayList<Account> listAccountsClient) {
        this.listAccountsClient = listAccountsClient;
    }

    public Client(String name, Account account) {
        this.name = name;
        listAccountsClient = new ArrayList<>();
        listAccountsClient.add(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getListAccountsClient() {
        return listAccountsClient;
    }

    public String toString() {
        String data = "---------------------------------------------" + "\n" + "Owner: " + getName();
        for (Account account: listAccountsClient) {
            data += "\n" + account + "\n";
        }
        data += "---------------------------------------------";
        return data;
    }
}
