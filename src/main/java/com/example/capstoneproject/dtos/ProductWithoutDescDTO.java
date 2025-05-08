package com.example.capstoneproject.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductWithoutDescDTO {
    private String name;
    private double price;
    private String imageURL;
    private String category;
}
