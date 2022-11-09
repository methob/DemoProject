package com.jonathan.test.demo.service;

import com.jonathan.test.demo.entity.Category;
import com.jonathan.test.demo.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public  List<Category> listAll() {
        return categoryRepository.findAll();
    }
    public Optional<Category> searchByCode(Long code) {
        return categoryRepository.findById(code);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long code, Category category) {
        Category newCategory =  validateCategoryExist(code);
        BeanUtils.copyProperties(category, newCategory, "code");
        return categoryRepository.save(newCategory);
    }
    private Category validateCategoryExist(Long code) {
        Optional<Category> category = searchByCode(code);
        if (!category.isPresent()) {
            throw new EmptyResultDataAccessException(1);
        }
        return category.get();
    }
}
