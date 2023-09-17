package NesteRundeKalkulator;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Session {
    private List<User> users = new ArrayList<User>();
    private List<Beverage> beverages = new ArrayList<Beverage>();
    private String name;

    public Session(String name) {
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
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void buyRound(User user, Beverage beverage) {
        int amount = beverage.getPrice();
        int drinks = users.size();
        user.setBalance(drinks*amount);
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
            }
        }
        return nextUser;
    }

    public static void main (String[] args) {
        Session session = new Session("session");
        User eskil = new User("Eskilmo");
        session.addUser(eskil);

        User anders = new User("Anders");
        session.addUser(anders);
        User hakon = new User("hakon");
        session.addUser(hakon);

        Beverage beer = new Beverage("beer", 50);
        Beverage cocktail = new Beverage("cocktail", 60);
        Beverage shot = new Beverage("shot", 100);
        session.beverages.add(beer);
        session.beverages.add(cocktail);
        session.beverages.add(shot);
        session.buyRound(hakon, shot);
        System.out.println(session.getUsers());
        System.out.println(session.suggestNextUser());
        System.out.println(session.suggestNextUser());
        System.out.println(session.suggestNextUser());
        System.out.println(session.suggestNextUser());
    }
}
