package com.jonathan.test.demo.repositories;

import com.jonathan.test.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
