package NesteRundeKalkulator;

import java.util.List;
import java.util.ArrayList;

public class Session {
    private List<User> users = new ArrayList<User>();
    private String name;

    public Session(List<User> users, String name) {
        this.users = users;
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
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
