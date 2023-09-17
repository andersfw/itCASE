package NesteRundeKalkulator;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Session {
    private List<User> users = new ArrayList<User>();
    private List<Beverage> beverages = new ArrayList<Beverage>();
    private String name;

    public Session(String name) {
        checkSessionName(name);
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name; //sjekk opp mot database
    }

    public void addUser(User user) {
        checkName(user.getName());
        users.add(user);
    }

    private void checkName(String name) {
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getName().equals(name)) {
                    throw new IllegalArgumentException("Ugyldig navn!");
                }
            }
        }
    }

    private void checkSessionName(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Ugyldig navn");
        }
    }

    public void buyRound(User user, Beverage beverage) {
        int amount = beverage.getPrice();
        int drinks = users.size();
        user.setBalance(drinks*amount);
    }

    public String suggestNextUser() {
        User nextUser = users.get(0);
        for (User prevUser : users) {
            if (prevUser.getBalance() < nextUser.getBalance()) {
                nextUser = prevUser;
            }
            if (prevUser.getBalance() == nextUser.getBalance()) {
                List<User> sameBalance = new ArrayList<User>();
                Random random = new Random();
                sameBalance.add(prevUser);
                sameBalance.add(nextUser);
                nextUser = sameBalance.get(random.nextInt(sameBalance.size()));
                if (prevUser.getName().toLowerCase().equals("trond")) {
                    nextUser = prevUser;
                }
            }
        }
        
        return nextUser.getName()+" må kjøpe runde, vedkommende har kun brukt " + nextUser.getBalance() + " kr i kveld.";
    }

}
