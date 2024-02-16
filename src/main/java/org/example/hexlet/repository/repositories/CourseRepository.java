package org.example.hexlet.repository.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Setter;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.Data;
import org.example.hexlet.repository.BaseRepository;

public class CourseRepository extends BaseRepository {
    public static List<Course> getEntities() {
        var sql = "SELECT * FROM courses";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Course>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var body = resultSet.getString("body");
                var course = new Course(name, body);
                course.setId(id);
                result.add(course);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(Course course) {
        String sql = "INSERT INTO courses (name, body) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getBody());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                course.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Failed to obtain auto-generated key for inserted record.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<Course> find(Long id) {
        var sql = "SELECT * FROM courses WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var body = resultSet.getString("body");
                var course = new Course(name, body);
                course.setId(id);
                return Optional.of(course);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int size() {
        String sql = "SELECT COUNT(*) FROM courses";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {
            var resultSet = preparedStatement.executeQuery();
            var result = 0;
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void delete(Long id) {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Course course) {
        String sql = "UPDATE courses SET name = ?, body = ? WHERE id = ?";
        try (var stmt = dataSource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(3, course.getId());
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getBody());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}