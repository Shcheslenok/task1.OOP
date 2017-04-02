package task1.sorting;

import task1.model.Account;

import java.util.Comparator;

/**
 * Helper class to use interface To sort accounts by client name
 * Created by Shcheslenok on 26.03.2017.
 */
public class SortedByNumberAccount  implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        String owner1 = o1.getAccountNumber();
        String owner2 = o2.getAccountNumber();

        return owner1.compareTo(owner2);
    }
}
