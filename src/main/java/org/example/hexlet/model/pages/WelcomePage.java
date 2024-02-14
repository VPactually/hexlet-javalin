package org.example.hexlet.model.pages;

public class WelcomePage implements Page{
    private String name;
    private boolean visited = false;
    public WelcomePage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean isVisited() { return visited;}
    public void setVisited(Boolean visit) {
        this.visited = visit;
    }
}
