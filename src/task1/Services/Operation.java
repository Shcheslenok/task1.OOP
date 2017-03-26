package task1.Services;

import task1.Model.Account;
import task1.Model.Bank;
import task1.Model.Client;
import task1.Sorting.*;

import java.util.Scanner;

/**
 * Class contain input methods
 * and to create menu
 *
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Operation {

    public static int inputNumber(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String inputString(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static void menu() {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Select an action...");
            System.out.println("1)Add account");
            System.out.println("2)Delete account");
            System.out.println("3)View all money");
            System.out.println("4)Count positive and negative balances");
            System.out.println("5)Block an account");
            System.out.println("6)Unblock an account");
            System.out.println("7)View data");
            System.out.println("8)Sort by amount of money");
            System.out.println("9)Sort by client");
            System.out.println("0)Exit");
            System.out.println("---------------------------------------------");

            menu:
            switch (Operation.inputNumber()){
                case 1: {

                    while (true) {
                        System.out.println("---------------------------------------------");
                        System.out.println("1)Add new client");
                        System.out.println("2)Add new account for client");
                        System.out.println("0)Previous");
                        System.out.println("---------------------------------------------");

                        switch (Operation.inputNumber()) {
                            case 1: {
                                Client client;
                                Account account = new Account();

                                System.out.print("Enter client name:");
                                account.setOwner(Operation.inputString());
                                System.out.print("Enter account number: ");
                                account.setAccountNumber(Operation.inputString());
                                System.out.print("Enter amount of money: ");
                                account.setAmountMoney(Operation.inputNumber());
                                account.setBlocked(false);

                                ServiceBank.addAccount(account);
                                client = new Client(account.getOwner(), account.getAccountNumber());
                                ServiceBank.addClient(client);
                                break menu;
                            }
                            case 2: {
                                Account account = new Account();
                                System.out.print("Enter owner: ");
                                account.setOwner(Operation.inputString());
                                System.out.print("Enter account number: ");
                                account.setAccountNumber(Operation.inputString());
                                System.out.print("Enter amount of money: ");
                                account.setAmountMoney(Operation.inputNumber());
                                account.setBlocked(false);
                                ServiceBank.addAccount(account);
                                for (Client client: ServiceBank.getListClients()) {
                                    if (client.getName().equals(account.getOwner())){
                                        ServiceClient.addAccount(client, account);
                                        break menu;
                                    }
                                }
                            }
                            case 0: {
                                break menu;
                            }
                            default: {
                                System.out.println("---------------------------------------------");
                                System.out.println("Impossible choice or format. Repeat please ...");
                            }
                        }
                    }
                }
                case 2: {

                    System.out.print("Enter account number for delete: ");
                    String numberAccount = Operation.inputString();
                    ServiceBank.deleteAccount(numberAccount);
                    for (Client client: ServiceBank.getListClients()){
                        for (String str: client.getListAccountsClient()) {
                            if (str.equals(numberAccount)){
                                ServiceClient.deleteAccount(client, numberAccount);
                                break menu;
                            }
                        }
                    }
                }
                case 3: {
                    System.out.println("All money: " + ServiceBank.countMoney());
                    break;
                }
                case 4: {
                    System.out.println("Positive balance: " + ServiceBank.countPositiveBalance());
                    System.out.println("Negative balance: " + ServiceBank.countNegativeBalance());
                    break;
                }
                case 5: {
                    ServiceBank.block();
                    break;
                }
                case 6: {
                    ServiceBank.unblock();
                    break;
                }
                case 7: {

                    while (true) {
                        System.out.println("---------------------------------------------");
                        System.out.println("1)View all accounts");
                        System.out.println("2)View all clients");
                        System.out.println("0)Previous");
                        System.out.println("---------------------------------------------");

                        switch (Operation.inputNumber()) {
                            case 1: {
                                for (Account account : ServiceBank.getListAccountsBank()) {
                                    System.out.println(account);
                                }
                                break;
                            }
                            case 2: {
                                for (Client client: Bank.getListClients()) {
                                    System.out.println(client);
                                }
                                break;
                            }
                            case 0: {
                                break menu;
                            }
                            default: {
                                System.out.println("---------------------------------------------");
                                System.out.println("Impossible choice or format. Repeat please ...");
                            }
                        }
                    }
                }
                case 8: {
                    Bank.getListAccountsBank().sort(new SortedByAmountMoney());

                    for (Account account: Bank.getListAccountsBank()) {
                        System.out.println(account);
                    }
                    break;
                }
                case 9: {
                    Bank.getListAccountsBank().sort(new SortedByClient());

                    for (Account account: Bank.getListAccountsBank()) {
                        System.out.println(account);
                    }
                    break;
                }
                case 0: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Work completed");
                    ServicesFile.writeFile();
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }
                default: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Impossible choice or format. Repeat please ...");
                }
            }
        }
    }
}
