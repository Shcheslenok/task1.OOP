package model.services;

import model.beans.Account;
import model.beans.Client;

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
