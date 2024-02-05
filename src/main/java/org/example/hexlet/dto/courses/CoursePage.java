package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.Course;

@Getter
public class CoursePage {
    private Course course;
    
    public CoursePage(Course course){
        this.course = course;
    }
}
