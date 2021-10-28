package com.sebtask.sebproducts.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebtask.sebproducts.model.Product;
import com.sebtask.sebproducts.model.search.ProductSearch;
import com.sebtask.sebproducts.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {this.service = service;}

    @PostMapping("/filtered")
    public List<Product> getAllProducts (@RequestBody ProductSearch params) {
        return service.findProductsByParams(params, service.getProductsFromFile("src/main/resources/mock/products.json"));
    }
}
