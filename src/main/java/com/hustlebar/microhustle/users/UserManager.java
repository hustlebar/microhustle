package com.hustlebar.microhustle.users;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author tham
 */

@Singleton
public class UserManager {
    private static List<User> users = new ArrayList<>(10);

    List<User> all() {
        return users;
    }

    static {
        users.add(new User("tham@gmail.com", UUID.randomUUID().toString(), "Tham"));
    }
}
