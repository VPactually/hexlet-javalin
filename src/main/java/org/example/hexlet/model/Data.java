package org.example.hexlet.model;

import java.util.Random;
import java.util.Locale;

import net.datafaker.Faker;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.stream.LongStream;

public class Data {
    private static final long ITEMS_COUNT = 30;

    private static long idCounter = ITEMS_COUNT;

    public static List<User> getUsers() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<Long> ids = LongStream
                .range(1, ITEMS_COUNT + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<User> users = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            var id = ids.get(i);
            var firstName = faker.name().firstName();
            var email = faker.internet().emailAddress();
            var password = faker.internet().password();
            User user = new User(id, firstName, email, password);
            users.add(user);
        }

        return users;
    }

    public static List<Course> getCourses() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<Long> ids = LongStream
                .range(1, ITEMS_COUNT + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            var id = ids.get(i);
            var name = faker.educator().course();
            var description = faker.lorem().sentence();
            Course course = new Course(name, description, id);
            courses.add(course);
        }
        return courses;
    }

    public static long getNextId() {
        long id = ++idCounter;
        return id;
    }
}
