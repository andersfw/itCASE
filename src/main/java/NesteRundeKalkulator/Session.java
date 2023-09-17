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

    
}
