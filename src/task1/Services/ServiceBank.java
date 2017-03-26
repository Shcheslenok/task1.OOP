package task1.Services;

import task1.Model.Account;
import task1.Model.Bank;
import task1.Model.Client;

import java.util.ArrayList;

/**
 * Class to work with data of Bank
 * Created by коля on 25.03.2017.
 */
public class ServiceBank extends Bank {
    public static void addAccount(Account account) {
        getListAccountsBank().add(account);
    }

    public static ArrayList<Account> deleteAccount(String numberAccount){
        for (Account account: getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                getListAccountsBank().remove(account);
                break;
            }
        }
        return getListAccountsBank();
    }

    public static int countMoney() {
        int sumAll = 0;
        for (Account account : getListAccountsBank()) {
            sumAll += account.getAmountMoney();
        }
        return sumAll;
    }

    public static int countPositiveBalance() {
        int sumPositive = 0;
        for (Account account : getListAccountsBank()) {
            if (account.getAmountMoney() > 0) {
                sumPositive += account.getAmountMoney();
            }
        }
        return sumPositive;
    }

    public static int countNegativeBalance() {
        int sumNegative = 0;
        for (Account account: getListAccountsBank()) {
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

        for (Account account: getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(true);
                break;
            }
        }
        return getListAccountsBank();
    }

    public static ArrayList<Account> unblock() {
        String numberAccount;
        System.out.print("Enter number of account for unblock: ");
        numberAccount = Operation.inputString();

        for (Account account: getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(false);
                break;
            }
        }
        return getListAccountsBank();
    }

    public static ArrayList<Client> addClient(Client client) {
        getListClients().add(client);
        return getListClients();
    }

    public static void putMoney(){
        String numberAccount;
        System.out.print("Enter number of account: ");
        numberAccount = Operation.inputString();
        for (Account account: getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)){
                if (account.isBlocked()){
                    System.out.println("Account is blocked");
                    break;
                }
                else {
                    System.out.print("Enter the amount of money:");
                    account.setAmountMoney(account.getAmountMoney() - Operation.inputNumber());
                    break;
                }
            }
        }
    }


    public static void pullOffMoney(){
        String numberAccount;
        System.out.print("Enter number of account: ");
        numberAccount = Operation.inputString();
        for (Account account: getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)){
                if (account.isBlocked()){
                    System.out.println("Account is blocked");
                    break;
                }
                else {
                    System.out.print("Enter the amount of money:");
                    account.setAmountMoney(account.getAmountMoney() - Operation.inputNumber());
                    break;
                }
            }
        }
    }
}
