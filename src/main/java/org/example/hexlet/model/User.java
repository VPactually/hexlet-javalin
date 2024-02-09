package org.example.hexlet.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class User {
    private long id;
    private String firstName;
    private String email;
    private String password;

    public User(long id, String firstName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return firstName;
    }

}
