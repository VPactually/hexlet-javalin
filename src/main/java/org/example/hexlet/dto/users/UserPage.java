package org.example.hexlet.dto.users;

import org.example.hexlet.model.User;
import org.example.hexlet.model.pages.Page;

// BEGIN
public class UserPage implements Page {
    private User user;

    public UserPage(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
// END
