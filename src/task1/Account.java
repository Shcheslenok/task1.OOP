package task1;

public class Account {
    private String owner;
    private String accountNumber;
    private int amountMoney;
    private boolean blocked;


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
}
