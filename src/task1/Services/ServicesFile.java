package task1.Services;

import task1.Model.Account;
import task1.Model.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for work with files
 * Created by Shcheslenok on 26.03.2017.
 */
public class ServicesFile {
    public static void readFile(ArrayList<String> list, File file) {
        try {
            Scanner input = new Scanner(new BufferedReader(new FileReader(file)));
            while(input.hasNext()) {
                list.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(file.getName() + "not found");
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/file/accounts.txt")))) {
            for (Account account: Bank.getListAccountsBank()) {
                pw.println(account.getOwner() + " " + account.getAccountNumber() + " " +
                            account.getAmountMoney() + " " + account.isBlocked());
            }
            System.out.println("The data was successfully written to a file accounts.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
