package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class Course {
    private long id;
    private String name;
    private String body;

    public Course(String name, String body, Long id) {
        this.name = name;
        this.body = body;
        this.id = id;
    }

    public Course(String name, String body) {
        this.name = name;
        this.body = body;
    }
}
