package task1.sorting;

import task1.model.Account;

import java.util.Comparator;

/**
 * Helper class to use interface to sort accounts by amount of money
 * Created by Shcheslenok on 26.03.2017.
 */
public class SortedByAmountMoney implements Comparator<Account> {
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
