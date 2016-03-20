package com.studyjam.studyjam.lesson2.manager;

import com.studyjam.studyjam.lesson2.model.User;

/**
 * Created by PedroCarrillo on 3/16/16.
 */
public class UserManager {

    private User user;

    private static UserManager ourInstance = new UserManager();

    public static UserManager getInstance() {
        return ourInstance;
    }

    private UserManager() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
