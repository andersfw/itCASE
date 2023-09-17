package NesteRundeKalkulator;

public class User {
    
    private String name;
    private int balance;
    
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", balance=" + balance + "]";
    }

    
}
