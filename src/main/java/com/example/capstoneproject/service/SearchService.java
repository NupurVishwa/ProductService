package com.example.capstoneproject.service;

import com.example.capstoneproject.models.Product;
import org.springframework.data.domain.Page;

import java.net.InterfaceAddress;

public interface SearchService
{
    Page<Product> search(String query, int pageNumber, int pageSize, String sortParam);
}