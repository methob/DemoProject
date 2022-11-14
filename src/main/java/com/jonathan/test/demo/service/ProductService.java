package com.jonathan.test.demo.service;

import com.jonathan.test.demo.entity.Category;
import com.jonathan.test.demo.entity.Product;
import com.jonathan.test.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Optional<Product> searchByCode(Long code) {
        return productRepository.findById(code);
    }

    public List<Product> getProductsOfCategory(Category category) {
        return productRepository.findByCategory(category);
    }
    private void validateCategoryExist() {

    }
}
