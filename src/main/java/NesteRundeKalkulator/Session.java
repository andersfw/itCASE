package NesteRundeKalkulator;

import java.util.List;
import java.util.ArrayList;

public class Session {
    private List<User> users = new ArrayList<User>();
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

    

    
}
