package org.example.hexlet.controller;


import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.sessions.BuildSessionPage;

import java.util.Collections;

public class SessionsController {
    public static void build(Context ctx) {
        var page = new BuildSessionPage();
        ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("nickname");
        try {
            var password = ctx.formParamAsClass("password", String.class)
                    .check(v -> v.length() > 6, "Short password")
                    .get();
            ctx.sessionAttribute("currentUser", nickname);
            ctx.redirect("/");
        } catch (ValidationException e) {
            var page = new BuildSessionPage(nickname, null, e.getErrors());
            ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
        }

    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }

}
