package task1.Model;

/**
 * Class contains data about account
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Account {
    /**The name of the account holder*/
    private String owner;
    /**The number of account*/
    private String accountNumber;
    /**The amount of money*/
    private int amountMoney;
    /**Account blocking(true - blocked)*/
    private boolean blocked;

    public Account() {
        owner = null;
        accountNumber = null;
        amountMoney = 0;
        blocked = false;
    }

    public Account(String owner, String accountNumber, int amountMoney, boolean blocked){
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.amountMoney = amountMoney;
        this.blocked = blocked;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(int amountMoney) {
        this.amountMoney = amountMoney;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String toString(){
        return "---------------------------------------------" + "\n" +
                "Owner: " + getOwner() + "\n" +
                "Number of account: " + getAccountNumber() + "\n" +
                "Amount of account: " + getAmountMoney() + "\n" +
                "Blocked: " + isBlocked() + "\n" +
                "---------------------------------------------";
    }
}
