package task1.services;

import task1.model.Account;
import task1.model.Client;

/**
 * Class to work with data of clint
 * Created by Shcheslenok on 25.03.2017.
 */
public class ServiceClient {

    public static void addAccount(Client client, Account account) {
        client.getListAccountsClient().add(account);
    }

    public static void deleteAccount(Client client, Account account) {
        client.getListAccountsClient().remove(account);
    }
}
