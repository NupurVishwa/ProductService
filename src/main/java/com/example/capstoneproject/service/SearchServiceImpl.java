package com.example.capstoneproject.service;

import com.example.capstoneproject.models.Product;
import com.example.capstoneproject.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService
{
    ProductRepository productRepository;

    public SearchServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> search(String query,
                                int pageNumber, int pageSize,
                                String sortParam)
    {
        Sort sort = Sort.by(sortParam).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findByNameContaining(query, pageable);
    }
}