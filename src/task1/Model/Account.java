package task1.Model;

/**
 * Стартовый класс
 *
 * @version 1.0 19 Mar 2017
 * @author  Petr Shcheslenok
 */
public class Account {
    /**Имя владельца счета*/
    private String owner;
    /**Номер счета*/
    private String accountNumber;
    /**Колличество денег на счете*/
    private int amountMoney;
    /**Блокировка счета(true - заблокирован)*/
    private boolean blocked;

    public Account() {
        owner = null;
        accountNumber = null;
        amountMoney = 0;
        blocked = false;
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

    /*public int replenishAccount() {

    }

    public int pullOff() {

    }*/
}
