package com.e_Commerce_app_group.e_commerce_dashboard.Pojos;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
@Data
public class ProductEntity {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private int price;
    @NonNull
    private int stock;

}
