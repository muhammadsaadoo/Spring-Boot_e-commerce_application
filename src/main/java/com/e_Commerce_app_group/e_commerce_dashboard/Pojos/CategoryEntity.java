package com.e_Commerce_app_group.e_commerce_dashboard.Pojos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "categories")
@Data
public class CategoryEntity {
    @Id
    private ObjectId id;


    @NonNull
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Indexed(unique = true)
    private String name;


    @NonNull
    @NotBlank(message = "description is mandatory")
    @Size(min = 2, max = 100, message = "description should be between 2 and 30 characters")
    private String description;


    private int no_of_products;




    List<ObjectId> listOfProductsIds=new ArrayList<>();


}
