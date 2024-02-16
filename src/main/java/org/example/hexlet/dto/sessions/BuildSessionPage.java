package org.example.hexlet.dto.sessions;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.model.pages.Page;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildSessionPage implements Page {
    private String email;
    private String password;
    private Map<String, List<ValidationError<Object>>> errors;
    private String error;

    public BuildSessionPage(String error) {
        this.error = error;
    }

    public BuildSessionPage(String email, String password, Map<String, List<ValidationError<Object>>> errors) {
        this.email = email;
        this.password = password;
        this.errors = errors;
    }
}
