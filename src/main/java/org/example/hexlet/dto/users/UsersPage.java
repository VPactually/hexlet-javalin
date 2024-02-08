package org.example.hexlet.dto.users;

import org.example.hexlet.model.Page;
import org.example.hexlet.model.User;

import java.util.List;

import static org.example.hexlet.App.USERS;

// BEGIN
public final class UsersPage implements Page {
    private List<User> users;
    private String header;
    int totalPages;
    int currentPage;
    private String term;

    public UsersPage(List<User> users, String header, Integer totalPages, Integer currentPage, String term) {
        this.users = users;
        this.header = header;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.term = term;
    }

    public UsersPage() {

    }

    public List<User> getUsers() {
        return users;
    }

    public String getHeader() {
        return header;
    }

    public String getTerm() {
        return this.term;
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
