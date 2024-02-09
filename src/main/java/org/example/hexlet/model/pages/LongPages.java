package org.example.hexlet.model.pages;

public interface LongPages {
    int getCurrentPage();

    int getTotalPages();

    int getPerParam();

    String getTerm();
}
