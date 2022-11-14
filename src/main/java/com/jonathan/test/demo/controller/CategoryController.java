package com.jonathan.test.demo.controller;

import com.jonathan.test.demo.dto.CategoryDTO;
import com.jonathan.test.demo.entity.Category;
import com.jonathan.test.demo.mapper.DemoMapper;
import com.jonathan.test.demo.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Category")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ApiOperation(value = "show all categories")
    public List<CategoryDTO> listAll(){
        return categoryService.listAll().stream()
                .map(DemoMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{code}")
    @ApiOperation(value = "Search category by id")
    public ResponseEntity<CategoryDTO> searchById(@PathVariable Long code) {
        Optional<Category> category = categoryService.searchByCode(code);
        return category.map(value -> ResponseEntity.ok(DemoMapper.toCategoryDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ApiOperation(value = "Save Category")
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody Category category) {
        Category localCategory = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(DemoMapper.toCategoryDTO(localCategory));
    }

    @PutMapping("update/{code}")
    @ApiOperation(value = "Update Category")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long code,
                                           @Valid @RequestBody Category category) {
        Category localCategory = categoryService.update(code, category);
        return ResponseEntity.status(HttpStatus.OK).body(DemoMapper.toCategoryDTO(localCategory));
    }

    @DeleteMapping("delete/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete Category")
    public void delete(@PathVariable Long code) {
        categoryService.delete(code);
    }
}
