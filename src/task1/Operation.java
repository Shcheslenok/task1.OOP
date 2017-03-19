package task1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Стартовый класс
 *
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Operation {
    /**Переменная для реализаци ввода с клавиатуры*/
    public static Scanner input = new Scanner(System.in);

    public static int inputNumber(){

        int number;
        //input = new Scanner(System.in);
        number = input.nextInt();
        return number;
    }

    public static String inputString(){

        String str;
        //input = new Scanner(System.in);
        str = input.next();
        return str;
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

                                Bank.addAccount(account);
                                client = new Client(account.getOwner(), account.getAccountNumber());
                                Bank.addClient(client);
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
                                Bank.addAccount(account);
                                for (Client client: Bank.getListClients()) {
                                    if (client.getName().equals(account.getOwner())){
                                        client.addAccount(account);
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
                    Bank.deleteAccount(numberAccount);
                    for (Client client: Bank.getListClients()){
                        for (String str: client.getListAccountsClient()) {
                            if (str.equals(numberAccount)){
                                client.deleteAccount(numberAccount);
                                break menu;
                            }
                        }
                    }
                }
                case 3: {
                    System.out.println("All money: " + Bank.countMoney());
                    break;
                }
                case 4: {
                    System.out.println("Positive balance: " + Bank.countPositiveBalance());
                    System.out.println("Negative balance: " + Bank.countNegativeBalance());
                    break;
                }
                case 5: {
                    Bank.block();
                    break;
                }
                case 6: {
                    Bank.unblock();
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
                                for (Account account : Bank.getListAccountsBank()) {
                                    account.printDataAccount();
                                }
                                break;
                            }
                            case 2: {
                                for (Client client: Bank.getListClients()) {
                                    client.printDataClient();
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
                    Collections.sort(Bank.getListAccountsBank(), new SortedByAmountMoney());

                    for (Account account: Bank.getListAccountsBank()) {
                        account.printDataAccount();
                    }
                    break;
                }
                case 9: {
                    Collections.sort(Bank.getListAccountsBank(), new SortedByClient());

                    for (Account account: Bank.getListAccountsBank()) {
                        account.printDataAccount();
                    }
                    break;
                }
                case 0: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Work completed");
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

    /**
     * Вспомогательный класс для использывания интерфейса
     * для реализации сортировки счетов по имени клиента
     */
    private static class SortedByClient  implements Comparator<Account> {
        @Override
        public int compare(Account o1, Account o2) {
            String owner1 = o1.getOwner();
            String owner2 = o2.getOwner();

            return owner1.compareTo(owner2);
        }
    }

    /**
     * Вспомогательный класс для использывания интерфейса
     * для реализации сортировки счетов по колличеству денег на счете
     */
    private static class SortedByAmountMoney implements Comparator<Account> {
        @Override
        public int compare(Account o1, Account o2) {
            int money1 = o1.getAmountMoney();
            int money2 = o2.getAmountMoney();

            if (money1 > money2){
                return 1;
            }
            else if (money1 < money2){
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}
