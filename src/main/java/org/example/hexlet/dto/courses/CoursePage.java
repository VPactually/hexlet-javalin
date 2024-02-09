package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.pages.Page;

public final class CoursePage implements Page {
    private Course course;

    public CoursePage(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

}
