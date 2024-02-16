package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.model.Data;
import org.example.hexlet.model.pages.WelcomePage;
import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.repository.repositories.CourseRepository;
import org.example.hexlet.repository.repositories.UserRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static String readResourceFile(String fileName) throws IOException {
        var inputStream = App.class.getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }

    }
    public static Javalin getApp() throws Exception {

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });


        var sql = readResourceFile("schema.sql");

        try (var statement = dataSource.getConnection().createStatement()){
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;
        return app;
    }

    public static void main(String[] args) throws Exception {

        var app = getApp();

        var users = Data.getUsers();
        for (var user : users) {
            UserRepository.save(user);
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
        }

        var courses = Data.getCourses();
        for (var course : courses) {
            CourseRepository.save(course);
        }

        app.get(NamedRoutes.rootPath(), ctx -> {
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
        app.post(NamedRoutes.deleteCoursePath("{id}"), CoursesController::destroy);

        app.get(NamedRoutes.sessionsBuildPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.post(NamedRoutes.deleteSessionPath(), SessionsController::destroy);

        app.start(7070);
    }

}
