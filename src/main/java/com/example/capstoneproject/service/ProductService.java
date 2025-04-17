package com.example.capstoneproject.service;

import com.example.capstoneproject.exceptions.ProductNotFoundException;
import com.example.capstoneproject.models.Product;

import java.util.List;

public interface ProductService
{
    Product getProduct(int id);

    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(String name, String description, double price,
                          String imageUrl, String category);
}