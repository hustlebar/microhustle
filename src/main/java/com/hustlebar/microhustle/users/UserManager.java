package com.hustlebar.microhustle.users;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 */

@Singleton
public class UserManager {
    private static List<User> users = new ArrayList<>(10);

    List<User> all() {
        return users;
    }

    User get(String name) {
        User matchedUser = null;
        for (User user : users) {
            if (user.getName().equals(name)) {
                matchedUser = user;
                break;
            }
        }

        return matchedUser;
    }

    static {
        users.add(new User("tham@gmail.com", "Tham"));
        users.add(new User("roger@gmail.com", "Roger"));
    }

    public void create(User user) {
        users.add(user);
        System.out.println("User created successfully!");
    }
}
