package com.e_Commerce_app_group.e_commerce_dashboard.Pojos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "admin")
@Data

public class SignUpEntity {
    @Id
    private ObjectId id;
    @NonNull
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String userName;
    @Indexed(unique = true)
    @NonNull
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "Email should be valid")
    private String email;
    @NonNull
    @NotBlank(message = "Password is mandatory")
    @Size(min = 2, max = 30, message = "password should be between 2 and 30 characters")
    private String password;

    private List<String> roles;
    List<ObjectId> addToCart=new ArrayList<>();


    public SignUpEntity() {

    }
}
