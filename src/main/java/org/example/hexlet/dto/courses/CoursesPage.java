package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.pages.LongPages;
import org.example.hexlet.model.pages.Page;
import org.example.hexlet.repository.CourseRepository;

import java.util.List;

public class CoursesPage implements LongPages, Page {
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
        return CourseRepository.size() / totalPages;
    }

}
