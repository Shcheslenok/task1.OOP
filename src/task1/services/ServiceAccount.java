package task1.services;

import task1.model.Account;
import task1.model.Bank;
import task1.model.Client;

import java.io.File;

/**
 * Service to work with class Accounts
 * Created by Shcheslenok on 25.03.2017.
 */
public class ServiceAccount {
    /**Method to initialize the saved data*/
    public static Bank initializationAccounts() {
        Bank bank = new Bank();
        File file = new File("src/file/accounts.txt");
        String string = ServicesFile.readFile(file);
        String[] str = string.split("\\s");

        for (int i = 0; i < str.length; i += 4){
            Account account = new Account(str[i + 1], Integer.parseInt(str[i + 2]), Boolean.parseBoolean(str[i + 3]));
            Client client = new Client(str[i], account);

            ServiceBank.addAccount(bank, account);
            ServiceBank.addClient(bank, client);
        }
        return bank;
    }
}
