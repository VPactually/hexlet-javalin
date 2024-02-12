package org.example.hexlet.dto.courses;

import lombok.Getter;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.pages.LongPages;
import org.example.hexlet.model.pages.Page;
import org.example.hexlet.repository.CourseRepository;

import java.util.List;
@Getter
public class CoursesPage implements LongPages, Page {
    private List<Course> courses;
    private int totalPages;
    private int currentPage;
    private String term;

    public CoursesPage(List<Course> courses, Integer totalPages, Integer currentPage, String term) {
        this.courses = courses;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.term = term;
    }

    public CoursesPage() {

    }

    public int getPerParam() {
        return CourseRepository.size() / totalPages;
    }

    public boolean hasNextPage() {
        return currentPage < totalPages;
    }

    public boolean hasPreviousPage() {
        return currentPage > 1;
    }
}