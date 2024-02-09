package org.example.hexlet.model.pages;


public interface Page {

    default String getHeader() {
        return this.getClass().getSimpleName();
    }

}
