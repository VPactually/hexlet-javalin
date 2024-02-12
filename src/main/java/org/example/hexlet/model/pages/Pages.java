package org.example.hexlet.model.pages;

import io.javalin.http.Context;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pages {

    public static<T> LongPages createPage(Context ctx, List<T> list, LongPages pages){
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(10);
        var term = ctx.queryParamAsClass("term", String.class).getOrDefault(null);

        page = page == 0 ? 1 : page;

        if (term != null) {
            term = term.toLowerCase();
            String finalTerm = term;
            list = list.stream().filter(el -> el.toString().toLowerCase().contains(finalTerm)).collect(Collectors.toList());
            if (list.isEmpty()) {
                list = new ArrayList<>();
            }
        }
        var startIndex = (page - 1) * per;
        var endIndex = Math.min(startIndex + per, list.size());

        switch (pages.getClass().getSimpleName()){
            case "CoursesPage" -> {
                return new CoursesPage((List<Course>) list.subList(startIndex, endIndex), term, per, page);
            }
            case "UsersPage" -> {
                return new UsersPage((List<User>) list.subList(startIndex, endIndex), term, per, page);
            }
            default -> throw new RuntimeException("Unsupported class" + page.getClass().getSimpleName());
        }
    }
}