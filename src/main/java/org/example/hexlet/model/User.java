package org.example.hexlet.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class User {
    private long id;
    private String name;
    private String email;
    private String password;

    public User(long id, String firstName, String email, String password) {
        this.id = id;
        this.name = firstName;
        this.email = email;
        this.password = password;
    }

}
