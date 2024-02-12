package org.example.hexlet.model.pages;

public interface LongPages {
    String getTerm();
    int getTotalPages();
    int getCurrentPage();
    int getPerParam();
    boolean hasNextPage();
    boolean hasPreviousPage();
}
