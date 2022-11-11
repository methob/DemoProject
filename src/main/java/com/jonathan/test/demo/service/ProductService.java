package com.jonathan.test.demo.service;

import com.jonathan.test.demo.entity.Category;
import com.jonathan.test.demo.entity.Product;
import com.jonathan.test.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

}
