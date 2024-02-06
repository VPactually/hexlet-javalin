package org.example.hexlet.dto.users;

import lombok.Getter;
import org.example.hexlet.model.User;

// BEGIN
public class UserPage {
    private User user;

    public UserPage(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
// END
