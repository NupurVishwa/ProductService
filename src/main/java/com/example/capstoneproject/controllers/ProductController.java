package com.example.capstoneproject.controllers;
import com.example.capstoneproject.dtos.CreateFakeStoreProductDto;
import com.example.capstoneproject.dtos.ProductResponseDto;
import com.example.capstoneproject.dtos.ProductWithoutDescDTO;
import com.example.capstoneproject.exceptions.ProductNotFoundException;
import com.example.capstoneproject.models.Product;
import com.example.capstoneproject.service.ProductAIService;
import com.example.capstoneproject.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
private final ProductAIService productAIService;
    ProductService productService;

    public ProductController(@Qualifier("ProductDBService")
                             ProductService productService,ProductAIService productAIService ) {
        this.productService = productService;
        this.productAIService = productAIService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById(
            @PathVariable("id") long id) throws ProductNotFoundException {

        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        return productResponseDto;
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

//        List<ProductResponseDto> productResponseDtos =
//                products.stream().map(ProductResponseDto::from)
//                        .collect(Collectors.toList());

        for (Product product : products) {
            ProductResponseDto productResponseDto = ProductResponseDto.from(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody
                                            CreateFakeStoreProductDto createFakeStoreProductDto) {
        Product product = productService.createProduct(
                createFakeStoreProductDto.getName(),
                createFakeStoreProductDto.getDescription(),
                createFakeStoreProductDto.getPrice(),
                createFakeStoreProductDto.getImageUrl(),
                createFakeStoreProductDto.getCategory()
        );

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        return productResponseDto;
    }

    public ProductResponseDto CreateProductDescriptionWithAI(@RequestBody ProductWithoutDescDTO productWithoutDescDTO){
        Product product = productAIService.CreateProductWithAIDesc(
                productWithoutDescDTO.getName(),
                productWithoutDescDTO.getPrice(),
                productWithoutDescDTO.getImageURL(),
                productWithoutDescDTO.getCategory()
        );
        return ProductResponseDto.from(product);
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ErrorDto handleNullPointerExceptions()
//    {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setStatus("Failure");
//        errorDto.setMessage("NullPointer exception occurred");
//
//        return errorDto;
//    }
}