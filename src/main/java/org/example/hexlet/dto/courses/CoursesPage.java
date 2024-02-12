package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.model.pages.LongPages;
import org.example.hexlet.model.pages.Page;
import org.example.hexlet.repository.CourseRepository;

import java.util.List;

@NoArgsConstructor
@Getter
public class CoursesPage implements LongPages, Page {
    private List<Course> courses;
    private String term;
    private int perPage;
    private int pageNumber;

    public CoursesPage(List<Course> courses) {
        this.courses = courses;
    }

    public CoursesPage(List<Course> courses, String term, int perPage, int pageNumber) {
        this.courses = courses;
        this.term = term;
        this.perPage = perPage;
        this.pageNumber = pageNumber;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getTotalPages() {
        return Math.max(courses.size() / perPage, courses.size());
    }

    @Override
    public int getPerPage() {
        return perPage;
    }
}