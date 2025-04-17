package com.example.capstoneproject.dtos;

import com.example.capstoneproject.models.Category;
import com.example.capstoneproject.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setDescription(description);
        product.setName(title);
        product.setPrice(price);
        product.setImageUrl(image);

        Category category1 = new Category();
        category1.setName(category);

        product.setCategory(category1);
        return product;

    }
}
