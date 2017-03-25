package task1.Model;

import java.util.ArrayList;

/**
 * Стартовый класс
 *
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Client {
    /**Имя клиента*/
    private String name;
    /**Список счетов клиента*/
    private ArrayList<String> listAccountsClient = new ArrayList<>();

    public Client(String name, String account) {
        this.name = name;
        listAccountsClient.add(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getListAccountsClient() {
        return listAccountsClient;
    }

    public ArrayList<String> addAccount(Account account) {
        listAccountsClient.add(account.getAccountNumber());
        return listAccountsClient;
    }

    public ArrayList<String> deleteAccount(String numberAccount) {
        listAccountsClient.remove(numberAccount);
        return listAccountsClient;
    }

    public String toString() {
        String data = "---------------------------------------------" + "\n" + "Owner: " + getName();
        for (String str: listAccountsClient) {
            data += "\t" + str + "\n";
        }
        data += "---------------------------------------------";
        return data;
    }
}
