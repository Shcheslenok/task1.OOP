package task1;

import java.util.ArrayList;

public class Bank {
    private static ArrayList<Account> listAccountsBank = new ArrayList<>();

    public static ArrayList<Account> getListAccountsBank() {
        return listAccountsBank;
    }

    public static ArrayList<Account> addAccount(Account account) {
        listAccountsBank.add(account);
        return listAccountsBank;
    }

    public static ArrayList<Account> deleteAccount(){
        System.out.println("Enter account number for delete");
        String numberAccount = Operation.inputString();
        for (Account account: listAccountsBank) {
            if (account.getAccountNumber().equals(numberAccount)) {
                listAccountsBank.remove(account);
                break;
            }
        }
        return listAccountsBank;
    }

    public static int countMoney() {
        int sumAll = 0;
        for (Account account : listAccountsBank) {
            sumAll += account.getAmountMoney();
        }

        return sumAll;
    }

    public static int countPositiveBalance() {
        int sumPositive = 0;
        for (Account account : listAccountsBank) {
            if (account.getAmountMoney() > 0) {
                sumPositive += account.getAmountMoney();
            }
        }

        return sumPositive;
    }

    public static int countNegativeBalance() {
        int sumNegative = 0;
        for (Account account: listAccountsBank) {
            if (account.getAmountMoney() < 0) {
                sumNegative += account.getAmountMoney();
            }
        }

        return sumNegative;
    }

    public static ArrayList<Account> block() {
        String numberAccount;
        System.out.print("Enter number of account for block: ");
        numberAccount = Operation.inputString();

        for (Account account: listAccountsBank) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(true);
                break;
            }
        }

        return listAccountsBank;
    }

    public static ArrayList<Account> unblock() {
        String numberAccount;
        System.out.print("Enter number of account for unblock: ");
        numberAccount = Operation.inputString();

        for (Account account: listAccountsBank) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(false);
                break;
            }
        }

        return listAccountsBank;
    }
}
