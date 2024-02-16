package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.EditCoursePage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.pages.Pages;
import org.example.hexlet.repository.repositories.CourseRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;

public class CoursesController {
    public static void index(Context ctx) {
        var courses = CourseRepository.getEntities();
        courses.sort(Comparator.comparing(Course::getId));
        var map = Collections.singletonMap("page", Pages.createPage(ctx, courses, new CoursesPage()));
        ctx.render("courses/index.jte", map);
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = Integer.parseInt(ctx.pathParam("id")) - 1;
        if (id > CourseRepository.getEntities().size() || id < 0) {
            ctx.status(404);
            ctx.result("Course not found");
        } else {
            Course course = CourseRepository.getEntities().get(id);
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        }

    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Short name")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Short description")
                    .get();
            var course = new Course(name, description, (long) CourseRepository.getEntities().size());
            CourseRepository.save(course);
            ctx.sessionAttribute("flash", "Course has been created!");
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage();
            page.setErrors(e.getErrors());
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new EditCoursePage(course, null);
        ctx.render("courses/edit.jte", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        try {
            var name = ctx.formParamAsClass("name", String.class).getOrDefault(null);
            var description = ctx.formParamAsClass("description", String.class).getOrDefault(null);
            course.setName(name != null ? name : course.getName());
            course.setBody(description != null ? description : course.getBody());
            CourseRepository.update(course);
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new EditCoursePage(course, e.getErrors());
            ctx.render("courses/edit.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }

}
