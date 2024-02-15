package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
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
            var visited = Boolean.parseBoolean(ctx.cookie("visited"));
            var page = new WelcomePage();
            page.setName(ctx.sessionAttribute("currentUser"));
            page.setVisited(visited);
            ctx.render("layout/welcomePage.jte", Collections.singletonMap("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.get(NamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.post(NamedRoutes.userPath("{id}"), UsersController::update);
        app.delete(NamedRoutes.deleteUserPath("{id}"), UsersController::destroy);

        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.get(NamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.post(NamedRoutes.coursePath("{id}"), CoursesController::update);
        app.delete(NamedRoutes.coursePath("{id}"), CoursesController::destroy);

        app.get(NamedRoutes.sessionsBuildPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.post(NamedRoutes.deleteSessionPath(), SessionsController::destroy);

        app.start(7070);
    }

}
