package org.example.hexlet.dto.users;

import org.example.hexlet.model.pages.LongPages;
import org.example.hexlet.model.pages.Page;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.util.List;

public final class UsersPage implements LongPages, Page {
    private List<User> users;
    private String header;
    int totalPages;
    int currentPage;
    private String term;

    public UsersPage(List<User> users, String header, int totalPages, int currentPage, String term) {
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
        return UserRepository.size() / totalPages;
    }
}
