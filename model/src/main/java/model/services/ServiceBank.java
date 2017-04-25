package model.services;

import model.beans.Bank;
import model.beans.Client;
import model.beans.Account;

import java.util.ArrayList;

/**
 * Class to work with data of Bank
 * Created by коля on 25.03.2017.
 */
public class ServiceBank {
    public static void addAccount(Bank bank, Account account) {
        if (bank.getListAccountsBank().isEmpty()){
            ArrayList<Account> list = new ArrayList<>();
            list.add(account);
            bank.setListAccountsBank(list);
        }
        else {
            bank.getListAccountsBank().add(account);
        }
    }

    public static ArrayList<Account> deleteAccount(Bank bank, String numberAccount){
        for (Account account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                bank.getListAccountsBank().remove(account);
                break;
            }
        }
        return bank.getListAccountsBank();
    }

    public static int countMoney(Bank bank) {
        int sumAll = 0;
        for (Account account : bank.getListAccountsBank()) {
            sumAll += account.getAmountMoney();
        }
        return sumAll;
    }

    public static int countPositiveBalance(Bank bank) {
        int sumPositive = 0;
        for (Account account : bank.getListAccountsBank()) {
            if (account.getAmountMoney() > 0) {
                sumPositive += account.getAmountMoney();
            }
        }
        return sumPositive;
    }

    public static int countNegativeBalance(Bank bank) {
        int sumNegative = 0;
        for (Account account: bank.getListAccountsBank()) {
            if (account.getAmountMoney() < 0) {
                sumNegative += account.getAmountMoney();
            }
        }
        return sumNegative;
    }

    public static ArrayList<Account> block(Bank bank) {
        String numberAccount;
        System.out.print("Enter number of account for block: ");
        numberAccount = Operation.inputString();

        for (Account account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(true);
                break;
            }
        }
        return bank.getListAccountsBank();
    }

    public static ArrayList<Account> unblock(Bank bank) {
        String numberAccount;
        System.out.print("Enter number of account for unblock: ");
        numberAccount = Operation.inputString();

        for (Account account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(false);
                break;
            }
        }
        return bank.getListAccountsBank();
    }

    public static ArrayList<Client> addClient(Bank bank, Client client) {
        if (bank.getListClients().isEmpty()){
            ArrayList<Client> list = new ArrayList<>();
            list.add(client);
            bank.setListClients(list);
        }
        else {
            bank.getListClients().add(client);
        }
        return bank.getListClients();
    }

    public static void changeAmountMoney(Bank bank, int plusOrMinusMoney){
        String numberAccount;
        System.out.print("Enter number of account: ");
        numberAccount = Operation.inputString();
        for (Account account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)){
                if (account.isBlocked()){
                    System.out.println("Account is blocked");
                    break;
                }
                else {
                    System.out.print("Enter the amount of money:");
                    account.setAmountMoney(account.getAmountMoney() + plusOrMinusMoney*Operation.inputNumber());
                    break;
                }
            }
        }
    }
}
