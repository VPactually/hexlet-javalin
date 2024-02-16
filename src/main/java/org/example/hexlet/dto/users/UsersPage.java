package org.example.hexlet.dto.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hexlet.model.pages.LongPages;
import org.example.hexlet.model.pages.Page;
import org.example.hexlet.model.User;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public final class UsersPage implements LongPages, Page {
    private List<User> users;
    private String term;
    private int perPage;
    private int pageNumber;
    private Object flash;


    public UsersPage(List<User> users) {
        this.users = users;
    }

    public UsersPage(List<User> users, String term, int perPage, int pageNumber) {
        this.users = users;
        this.term = term;
        this.perPage = perPage;
        this.pageNumber = pageNumber;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getTotalPages() {
        return Math.max(users.size() / perPage, users.size());
    }

    @Override
    public int getPerPage() {
        return perPage;
    }
}