package task1.Services;

import task1.Model.Account;
import task1.Model.Client;

/**
 * Class to work with data of clint
 * Created by Shcheslenok on 25.03.2017.
 */
public class ServiceClient {

    public static void addAccount(Client client, Account account) {
        client.getListAccountsClient().add(account.getAccountNumber());
    }

    public static void deleteAccount(Client client, String numberAccount) {
        client.getListAccountsClient().remove(numberAccount);
    }
}
