package task1;

import java.util.ArrayList;

public class Client {
    private String name;
    private static ArrayList<String> listAccountsClient = new ArrayList<>();

    public static ArrayList<String> getListAccountsClient() {
        return listAccountsClient;
    }
}
