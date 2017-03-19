package task1;

import java.util.Scanner;

public class Operation {
    public static Scanner input = new Scanner(System.in);

    public static int inputNumber(){

        int number;
        input = new Scanner(System.in);
        number = input.nextInt();
        return number;
    }

    public static String inputString(){

        String str;
        input = new Scanner(System.in);
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
            System.out.println("7)View all accounts");
            System.out.println("0)Exit");
            System.out.println("---------------------------------------------");

            switch (Operation.inputNumber()){

                case 1: {
                    Account account = new Account();
                    System.out.print("Enter owner: ");
                    account.setOwner(Operation.inputString());
                    System.out.print("Enter account number: ");
                    account.setAccountNumber(Operation.inputString());
                    System.out.print("Enter amount of money: ");
                    account.setAmountMoney(Operation.inputNumber());
                    account.setBlocked(false);
                    Bank.addAccount(account);
                    break;
                }
                case 2: {
                    Bank.deleteAccount();
                    break;
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

}
