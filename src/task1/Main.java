package task1;

import task1.Services.Operation;
import task1.Services.ServiceAccount;

/**
 * Starting class
 *
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Main {

    public static void main(String[] args) {
        ServiceAccount.initializationAccounts();
        Operation.menu();
    }
}
