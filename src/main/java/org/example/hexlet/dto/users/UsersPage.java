package org.example.hexlet.dto.users;

import lombok.Getter;
import org.example.hexlet.model.pages.LongPages;
import org.example.hexlet.model.pages.Page;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.util.List;

@Getter
public final class UsersPage implements LongPages, Page {
    private List<User> users;
    int totalPages;
    int currentPage;
    private String term;

    public UsersPage(List<User> users , int totalPages, int currentPage, String term) {
        this.users = users;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.term = term;
    }

    public UsersPage() {

    }

    public int getPerParam() {
        return UserRepository.size() / totalPages;
    }

    public boolean hasNextPage() {
        return currentPage < totalPages;
    }

    public boolean hasPreviousPage() {
        return currentPage > 1;
    }
}