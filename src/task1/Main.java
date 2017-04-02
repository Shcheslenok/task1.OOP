package task1;

import task1.model.Bank;
import task1.services.Operation;
import task1.services.ServiceAccount;

/**
 * Starting class
 *
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Main {

    public static void main(String[] args) {
        Bank bank;
        bank = ServiceAccount.initializationAccounts();
        Operation.menu(bank);
    }
}
