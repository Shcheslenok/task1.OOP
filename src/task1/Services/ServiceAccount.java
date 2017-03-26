package task1.Services;

import task1.Model.Account;
import task1.Model.Client;

import java.io.File;
import java.util.ArrayList;

/**
 * Service to work with class Accounts
 * Created by Shcheslenok on 25.03.2017.
 */
public class ServiceAccount {
    /**Method to initialize the saved data*/
    public static void initializationAccounts() {
        File file = new File("src/file/accounts.txt");

        ArrayList<String> temp = new ArrayList<>();

        ServicesFile.readFile(temp, file);

        for (String str: temp) {
            String[] s = str.split("\\s");

            Account account = new Account(s[0], s[1], Integer.parseInt(s[2]), Boolean.parseBoolean(s[3]));
            Client client = new Client(s[0], s[1]);

            ServiceBank.addAccount(account);
            ServiceBank.addClient(client);
        }
    }
}
