package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.Collections;
import java.util.List;


public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(javalinConfig -> {
            javalinConfig.bundledPlugins.enableDevLogging();
            javalinConfig.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result(String.format("Hello, %s!", name));
        });
        app.get("/courses", ctx -> {
            var courses = List.of(
                    new Course("Java", "New Java Course",12L),
                    new Course("Python", "New Python Course", 44L)
            );
            var header = "Programming courses";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });
        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = new Course("Course №" + id, "Description for course №" + id, 12L);
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });
        app.start(7070);
    }

}
