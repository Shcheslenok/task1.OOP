package task1.Model;

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
    private ArrayList<String> listAccountsClient = new ArrayList<>();

    public void setListAccountsClient(ArrayList<String> listAccountsClient) {
        this.listAccountsClient = listAccountsClient;
    }

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

    public String toString() {
        String data = "---------------------------------------------" + "\n" + "Owner: " + getName();
        for (String str: listAccountsClient) {
            data += "\t" + str + "\n";
        }
        data += "---------------------------------------------";
        return data;
    }
}
