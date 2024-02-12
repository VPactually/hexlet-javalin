package org.example.hexlet.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import io.javalin.validation.ValidationError;
import lombok.Setter;
import org.example.hexlet.model.pages.Page;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildUserPage implements Page {
    private String name;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;


}
