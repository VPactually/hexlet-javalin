package org.example.hexlet.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.Data;
import org.example.hexlet.model.User;

@Setter
public class CourseRepository {
    @Getter
    private static List<Course> entities = Data.getCourses();

    public static void save(Course course) {
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        var courses = entities.stream()
                .filter(entity -> entity.getName().contains(term))
                .toList();
        return courses;
    }

    public static Optional<Course> find(Long id) {
        var maybeCourse = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny();
        return maybeCourse;
    }

    public static void update(Course course) {
        entities = entities.stream().map(c -> c.getId() == course.getId() ? course : c).collect(Collectors.toList());
    }

    public static int size() {
        return entities.size();
    }
}