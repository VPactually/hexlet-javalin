package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import lombok.Getter;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.*;

import java.util.*;

public class App {

    public static final List<User> USERS = Data.getUsers();
    public static final List<Course> COURSES = Data.getCourses();


    public static void main(String[] args) {
        USERS.sort(Comparator.comparing(User::getId));
        COURSES.sort(Comparator.comparing(Course::getId));
        var app = Javalin.create(javalinConfig -> {
            javalinConfig.bundledPlugins.enableDevLogging();
            javalinConfig.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> {
            ctx.render(
                    "layout/welcomePage.jte",
                    Collections.singletonMap("page", new WelcomePage("Vladislav Pomozov")));
        });
        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result(String.format("Hello, %s!", name));
        });
        app.get("/users", ctx -> {
            ctx.render("users/index.jte", Collections.singletonMap("page", Pages.createPage(ctx, USERS)));
        });
        app.get("/users/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id")) - 1;
            if (id > USERS.size() || id < 0) {
                ctx.status(404);
                ctx.result("User not found");
            } else {
                User user = USERS.get(id);
                var page = new UserPage(user);
                ctx.render("users/show.jte", Collections.singletonMap("page", page));
            }
        });
        app.get("/courses", ctx -> {
            ctx.render("courses/index.jte", Collections.singletonMap("page", Pages.createPage(ctx, COURSES)));
        });
        app.get("/courses/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id")) - 1;
            if (id > COURSES.size() || id < 0) {
                ctx.status(404);
                ctx.result("Course not found");
            } else {
                Course course = COURSES.get(id);
                var page = new CoursePage(course);
                ctx.render("courses/show.jte", Collections.singletonMap("page", page));
            }
        });
        app.start(7070);
    }

}
