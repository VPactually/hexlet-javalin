package org.example.hexlet.model;

import io.javalin.http.Context;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UsersPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pages {

    public static<T> Page createPage(Context ctx, List<T> list, Page page){
        var pg = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(10);

        var term = ctx.queryParamAsClass("term", String.class).getOrDefault(null);
        if (term != null) {
            term = term.toLowerCase();
            String finalTerm = term;
            list = list.stream().filter(el -> el.toString().toLowerCase().contains(finalTerm)).collect(Collectors.toList());
           if (list.isEmpty()) {
               list = new ArrayList<>();
           }
        }

        int totalPages = list.size() / per;
        var startIndex = (pg - 1) * per;
        var endIndex = Math.min(startIndex + per, list.size());

        switch (page.getClass().getSimpleName()){
            case "CoursesPage" -> {
                return new CoursesPage((List<Course>) list.subList(startIndex, endIndex), "Courses Page", totalPages, pg, term);
            }
            case "UsersPage" -> {
                return new UsersPage((List<User>) list.subList(startIndex, endIndex), "UsersPage", totalPages, pg, term);
            }
            default -> throw new RuntimeException("Unsupported class" + page.getClass().getSimpleName());
        }
    }
}
