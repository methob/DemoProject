package com.jonathan.test.demo.repositories;

import com.jonathan.test.demo.entity.Category;
import com.jonathan.test.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
