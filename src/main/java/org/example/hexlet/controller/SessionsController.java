package org.example.hexlet.controller;


import io.javalin.http.Context;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.sessions.BuildSessionPage;
import org.example.hexlet.repository.repositories.UserRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class SessionsController {
    public static void build(Context ctx) {
        var page = new BuildSessionPage();
        ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var email = ctx.formParam("email");

        try {
            var user = UserRepository.getEntities().stream()
                    .filter(user1 -> user1.getEmail().equals(email))
                    .findFirst().get();
            var password = ctx.formParamAsClass("password", String.class)
                    .check(p -> p.equals(user.getPassword()), "Wrong password")
                    .get();
            ctx.sessionAttribute("currentUser", user.getName());
            ctx.redirect("/");
        } catch (ValidationException e) {
            var page = new BuildSessionPage(email, null, e.getErrors());
            ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
        } catch (NoSuchElementException e) {
            var page = new BuildSessionPage("User Not found");
            ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
        }

    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }

}
