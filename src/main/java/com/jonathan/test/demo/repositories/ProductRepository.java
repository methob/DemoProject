package com.jonathan.test.demo.repositories;

import com.jonathan.test.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
