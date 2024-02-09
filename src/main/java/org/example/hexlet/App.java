package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.*;
import org.example.hexlet.model.pages.Pages;
import org.example.hexlet.model.pages.WelcomePage;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.*;

public class App {

    public static List<User> usersFromRepo;
    public static List<Course> coursesFromRepo;


    public static void main(String[] args) {
        usersFromRepo = UserRepository.getEntities();
        usersFromRepo.sort(Comparator.comparing(User::getId));
        coursesFromRepo = CourseRepository.getEntities();
        coursesFromRepo.sort(Comparator.comparing(Course::getId));
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
            var map = Map.of("page", Pages.createPage(ctx, usersFromRepo, new UsersPage()));
            ctx.render("users/index.jte", map);
        });
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });
        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase(Locale.ROOT);
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(usersFromRepo.size(), name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");

        });
        app.get("/users/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id")) - 1;
            if (id > usersFromRepo.size() || id < 0) {
                ctx.status(404);
                ctx.result("User not found");
            } else {
                User user = usersFromRepo.get(id);
                var page = new UserPage(user);
                ctx.render("users/show.jte", Collections.singletonMap("page", page));
            }
        });
        app.get("/courses", ctx -> {

            ctx.render("courses/index.jte", Collections.singletonMap("page", Pages.createPage(ctx, coursesFromRepo, new CoursesPage())));
        });
        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });
        app.post("/courses", ctx -> {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            var course = new Course(name, description, (long) coursesFromRepo.size());

            CourseRepository.save(course);
            ctx.redirect("/courses");
        });
        app.get("/courses/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id")) - 1;
            if (id > coursesFromRepo.size() || id < 0) {
                ctx.status(404);
                ctx.result("Course not found");
            } else {
                Course course = coursesFromRepo.get(id);
                var page = new CoursePage(course);
                ctx.render("courses/show.jte", Collections.singletonMap("page", page));
            }
        });
        app.start(7070);
    }

}
