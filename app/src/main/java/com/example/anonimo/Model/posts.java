package com.example.anonimo.Model;

import com.example.anonimo.User;

public class posts {

    public posts(String description, User user) {
        this.description = description;
        this.user = user;
    }

    String description = "";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    User user = null;
}
