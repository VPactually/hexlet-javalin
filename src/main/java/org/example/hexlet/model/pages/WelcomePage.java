package org.example.hexlet.model.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WelcomePage implements Page{
    private String name;
    private boolean visited = false;
    public boolean isVisited() { return visited;}
}
