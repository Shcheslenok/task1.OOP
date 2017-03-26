package task1.Sorting;

import task1.Model.Account;

import java.util.Comparator;

/**
 * Helper class to use interface To sort accounts by client name
 * Created by Shcheslenok on 26.03.2017.
 */
public class SortedByClient  implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        String owner1 = o1.getOwner();
        String owner2 = o2.getOwner();

        return owner1.compareTo(owner2);
    }
}
