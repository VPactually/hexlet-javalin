package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.*;
import org.example.hexlet.model.pages.Pages;
import org.example.hexlet.model.pages.WelcomePage;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.*;

public class App {

    public static void main(String[] args) {
        var app = Javalin.create(javalinConfig -> {
            javalinConfig.bundledPlugins.enableDevLogging();
            javalinConfig.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> {
            ctx.render(
                    "layout/welcomePage.jte",
                    Collections.singletonMap("page", new WelcomePage("Vladislav Pomozov")));
        });
        app.get(NamedRoutes.usersPath(), ctx -> {
            var users = UserRepository.getEntities();
            users.sort(Comparator.comparing(User::getId));
            var map = Collections.singletonMap("page", Pages.createPage(ctx, users, new UsersPage()));
            ctx.render("users/index.jte", map);
        });
        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        });
        app.post(NamedRoutes.usersPath(), ctx -> {
            var name = Objects.requireNonNull(ctx.formParam("name")).trim();
            var email = Objects.requireNonNull(ctx.formParam("email")).trim().toLowerCase(Locale.ROOT);

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Wrong confirmation")
                        .check(value -> value.length() > 6, "Short password")
                        .get();
                var user = new User(Data.getUsers().size(), name, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", Collections.singletonMap("page", page));
            }


        });
        app.get(NamedRoutes.userPath("{id}"), ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            if (id > Data.getUsers().size() || id < 0) {
                ctx.status(404);
                ctx.result("User not found");
            } else {
                User user = UserRepository.find((long) id).get();
                var page = new UserPage(user);
                ctx.render("users/show.jte", Collections.singletonMap("page", page));
            }
        });
        app.get(NamedRoutes.coursesPath(), ctx -> {
            var courses = CourseRepository.getEntities();
            courses.sort(Comparator.comparing(Course::getId));
            var map = Collections.singletonMap("page", Pages.createPage(ctx, courses, new CoursesPage()));
            ctx.render("courses/index.jte", map);
        });
        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        });
        app.post(NamedRoutes.coursesPath(), ctx -> {
            try {
                var name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "Short name")
                        .get();
                var description = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "Short description")
                        .get();
                var course = new Course(name, description, (long) CourseRepository.getEntities().size());
                CourseRepository.save(course);
                ctx.redirect("/courses");
            } catch (ValidationException e) {
                var page = new BuildCoursePage();
                page.setErrors(e.getErrors());
                ctx.render("courses/build.jte", Collections.singletonMap("page", page));
            }
        });
        app.get(NamedRoutes.coursePath("{id}"), ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id")) - 1;
            if (id > CourseRepository.getEntities().size() || id < 0) {
                ctx.status(404);
                ctx.result("Course not found");
            } else {
                Course course = CourseRepository.getEntities().get(id);
                var page = new CoursePage(course);
                ctx.render("courses/show.jte", Collections.singletonMap("page", page));
            }
        });
        app.start(7070);
    }

}
