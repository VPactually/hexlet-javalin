package org.example.hexlet.model;

import io.javalin.http.Context;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UsersPage;

import java.util.List;

public class Pages {

    public static<T> Source createPage(Context ctx, List<T> list){
        var pg = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(10);
        int totalPages = list.size() / per;

        var startIndex = (pg - 1) * per;
        var endIndex = Math.min(startIndex + per, list.size());

        var switcher = list.get(0).getClass().getSimpleName();

        switch (switcher){
            case "Course" -> {
                return new CoursesPage((List<Course>) list.subList(startIndex, endIndex), "Courses Page", totalPages, pg);
            }
            case "User" -> {
                return new UsersPage((List<User>) list.subList(startIndex, endIndex), "UsersPage", totalPages, pg);
            }
            default -> throw new RuntimeException("Unsupported class" + switcher);
        }
    }
}
