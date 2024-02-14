package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.EditCoursePage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Data;
import org.example.hexlet.model.User;
import org.example.hexlet.model.pages.Pages;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.*;

public class UsersController {
    public static void index(Context ctx) {
        var users = UserRepository.getEntities();
        users.sort(Comparator.comparing(User::getId));
        var map = Collections.singletonMap("page", Pages.createPage(ctx, users, new UsersPage()));
        ctx.render("users/index.jte", map);
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with ID = " + id + " nor found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
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
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new EditUserPage(user, null);
        ctx.render("users/edit.jte", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParamAsClass("name", String.class).getOrDefault(null);
        var email = ctx.formParamAsClass("email", String.class).getOrDefault(null);
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Wrong confirmation")
                    .check(value -> value.length() > 6, "Short password")
                    .get();
            user.setName(name != null ? name : user.getName());
            user.setEmail(email != null ? name : user.getEmail());
            user.setPassword(password);
            UserRepository.update(user);
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new EditUserPage(user, e.getErrors());
            ctx.render("users/edit.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var method = ctx.formParamAsClass("_method", String.class).get();
        if (method.equals("delete")) {
            UserRepository.delete(id);
            ctx.redirect(NamedRoutes.usersPath());
        }
    }


}
