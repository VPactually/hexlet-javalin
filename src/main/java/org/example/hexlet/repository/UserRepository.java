package org.example.hexlet.repository;

import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import org.example.hexlet.model.Data;
import org.example.hexlet.model.User;

@Setter
public class UserRepository {
    @Getter
    private static List<User> entities = Data.getUsers();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<User> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<User> find(Long id) {
        var maybeUser = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny();
        return maybeUser;
    }

    public static int size() {
        return entities.size();
    }

}