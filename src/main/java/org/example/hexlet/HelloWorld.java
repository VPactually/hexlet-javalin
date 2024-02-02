package org.example.hexlet;

import io.javalin.Javalin;

import java.util.Optional;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(javalinConfig -> {
            javalinConfig.bundledPlugins.enableDevLogging();
        });
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result(String.format("Hello, %s!", name));
        });
        app.get("/users/{user_id}/post/{post_id}", ctx -> {
            ctx.result(String.format("Users ID = %d, Post ID = %d\n",
                    ctx.pathParamAsClass("user_id", Integer.class).get(), ctx.pathParamAsClass("post_id", Integer.class).get()));
        });

        app.start(7070);
    }
}
