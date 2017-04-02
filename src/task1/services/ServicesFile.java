package task1.services;

import task1.model.Account;
import task1.model.Bank;
import task1.model.Client;

import java.io.*;
import java.util.Scanner;

/**
 * Class for work with files
 * Created by Shcheslenok on 26.03.2017.
 */
public class ServicesFile {
    public static String readFile(File file) {
        String str = "";
        try(Scanner input = new Scanner(new BufferedReader(new FileReader(file)))){
            while(input.hasNext()) {
                str += input.nextLine() + " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println(file.getName() + "not found");
            e.printStackTrace();
        }
        return str;
    }

    public static void writeFile(Bank bank, File file) {
        String string = "";
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (Client client: bank.getListClients()) {
                for (Account account:client .getListAccountsClient()) {
                    string = account.getAccountNumber() + " " + account.getAmountMoney() + " " + account.isBlocked();
                }
                pw.println(client.getName() + " " + string);
            }
            System.out.println("The data was successfully written to a file accounts.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
