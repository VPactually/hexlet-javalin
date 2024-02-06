package org.example.hexlet.dto.courses;

import org.example.hexlet.App;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.Source;

import java.util.List;

import static org.example.hexlet.App.COURSES;

public class CoursesPage implements Source {
    private List<Course> courses;
    private String header;
    private int totalPages;
    private int currentPage;

    public CoursesPage(List<Course> courses, String header, Integer totalPages, Integer currentPage) {
        this.courses = courses;
        this.header = header;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getHeader() {
        return header;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPerParam() {
        return COURSES.size() / totalPages;
    }
}
