package org.example.hexlet.model;

public final class Course {
    private Long id;
    private String name;
    private String description;

    public Course(String name, String description, Long id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
