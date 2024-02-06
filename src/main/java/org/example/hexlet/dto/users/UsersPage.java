package org.example.hexlet.dto.users;

import org.example.hexlet.App;
import org.example.hexlet.model.Source;
import org.example.hexlet.model.User;

import java.util.List;

import static org.example.hexlet.App.USERS;

// BEGIN
public final class UsersPage implements Source {
    private List<User> users;
    private String description;
    private int totalPages;
    private int currentPage;

    public UsersPage(List<User> users, String description, Integer totalPages, Integer currentPage) {
        this.users = users;
        this.description = description;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPerParam() {
        return USERS.size() / totalPages;
    }
}
// END
