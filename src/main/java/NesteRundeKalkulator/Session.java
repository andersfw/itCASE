package NesteRundeKalkulator;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Session {
    private List<User> users = new ArrayList<User>();
    private List<Beverage> beverages = new ArrayList<Beverage>();
    private String name;
    private User buyingUser;

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

    public void setBuyingUser(User user) {
        this.buyingUser = user;
    }

    public User getBuyingUser() {
        return this.buyingUser;
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

    public User getRandomUser() {
        if (this.users == null || this.users.isEmpty()) {
            throw new IllegalArgumentException("The list is null or empty.");
        }

        for (User user : users) {
            if (user.getName().toLowerCase().equals("trond")) {
                return user;
            }
        }
        
        Random random = new Random();
        int randomIndex = random.nextInt(this.users.size());

        return this.users.get(randomIndex);
    }
    
    public void buyRound(User user, Beverage beverage) {
        int amount = beverage.getPrice();
        int drinks = users.size();
        user.setBalance(drinks*amount);
    }

    public void nextUserBuyRound(Beverage beverage) {
        User userToBuyRound = suggestNextUser();
        int amount = beverage.getPrice();
        int drinks = users.size();
        userToBuyRound.setBalance(drinks*amount);
    }

    public User suggestNextUser() {
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
        
        System.out.println(nextUser.getName()+" må kjøpe runde, vedkommende har kun brukt " + nextUser.getBalance() + " kr i kveld.");

        return nextUser;
    }

}
