package com.jonathan.test.demo.controller;

import com.jonathan.test.demo.dto.ProductDTO;
import com.jonathan.test.demo.entity.Category;
import com.jonathan.test.demo.entity.Product;
import com.jonathan.test.demo.mapper.DemoMapper;
import com.jonathan.test.demo.service.CategoryService;
import com.jonathan.test.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Product")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ApiOperation(value = "show all product")
    public List<ProductDTO> listAll(){
        return productService.listAll().stream()
                .map(DemoMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{code}")
    @ApiOperation(value = "Search product by id")
    public ResponseEntity<ProductDTO> searchById(@PathVariable Long code) {
        Optional<Product> product = productService.searchByCode(code);
        return product.map(value -> ResponseEntity.ok(DemoMapper.toProductDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("category/{code}")
    @ApiOperation(value = "show all product")
    public ResponseEntity<List<ProductDTO>> getProductOfCategory(Long categoryId){
        Optional<Category> category = categoryService.searchByCode(categoryId);
        return category.map(value -> ResponseEntity.ok(productService.getProductsOfCategory(value)
                .stream()
                .map(DemoMapper::toProductDTO)
                .collect(Collectors.toList()))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
