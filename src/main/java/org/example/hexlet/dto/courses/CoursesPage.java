package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.Page;

import java.util.List;

import static org.example.hexlet.App.COURSES;

public class CoursesPage implements Page {
    private List<Course> courses;
    private String header;
    private int totalPages;
    private int currentPage;
    private String term;

    public CoursesPage(List<Course> courses, String header, Integer totalPages, Integer currentPage, String term) {
        this.courses = courses;
        this.header = header;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.term = term;
    }

    public CoursesPage() {

    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getHeader() {
        return header;
    }

    public String getTerm() {
        return term;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPerParam() {
        return COURSES.size() / totalPages;
    }

}
