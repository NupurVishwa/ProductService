package com.example.capstoneproject.service;

import com.example.capstoneproject.models.Product;

public interface ProductAIService {
    Product CreateProductWithAIDesc(String name, double price, String imageURL, String category);
}
