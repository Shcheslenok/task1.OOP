package task1;

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

    Account() {
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

    public void printDataAccount(){
        System.out.println("---------------------------------------------");
        System.out.println("Owner: " + getOwner());
        System.out.println("Number of account: " + getAccountNumber());
        System.out.println("Amount of account: " + getAmountMoney());
        System.out.println("Blocked: " + isBlocked());
        System.out.println("---------------------------------------------");
    }

    /*public int replenishAccount() {

    }

    public int pullOff() {

    }*/
}
