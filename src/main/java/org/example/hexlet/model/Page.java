package org.example.hexlet.model;


public interface Page {

    int getCurrentPage();

    int getTotalPages();

    int getPerParam();

    String getHeader();

    String getTerm();
}
