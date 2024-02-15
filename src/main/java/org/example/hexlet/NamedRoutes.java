package org.example.hexlet;

public class NamedRoutes {

    public static String usersPath() {
        return "/users";
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String editUserPath(Long id) {
        return editUserPath(String.valueOf(id));
    }

    public static String editUserPath(String id) {
        return "/users/" + id + "/edit";
    }

    public static String deleteUserPath(String id) {
        return "/users/d/" + id;
    }

    public static String deleteUserPath(Long id) {
        return deleteUserPath(String.valueOf(id));
    }


    public static String coursesPath() {
        return "/courses";
    }

    public static String buildCoursePath() {
        return "/courses/build";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    public static String editCoursePath(Long id) {
        return editCoursePath(String.valueOf(id));
    }

    public static String editCoursePath(String id) {
        return "/courses/" + id + "/edit";
    }

    public static String sessionsBuildPath() {return "/sessions/build";}

    public static String sessionsPath() { return "/sessions";}

    public static String deleteSessionPath() {return "/sessions/delete";}


}
