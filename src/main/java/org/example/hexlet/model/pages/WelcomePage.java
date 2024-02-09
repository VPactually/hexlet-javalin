package org.example.hexlet.model.pages;

public class WelcomePage implements Page{
    private String name;
    public WelcomePage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
