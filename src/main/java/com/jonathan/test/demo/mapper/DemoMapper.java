package com.jonathan.test.demo.mapper;

import com.jonathan.test.demo.dto.CategoryDTO;
import com.jonathan.test.demo.dto.ProductDTO;
import com.jonathan.test.demo.entity.Category;
import com.jonathan.test.demo.entity.Product;

public class DemoMapper {

    public static CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(category.getCode(), category.getName());
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getCode(),
                product.getDescription(), product.getAmount(), product.getPriceCost(),
                product.getPriceSale(), product.getObservation(), product.getCategory());
    }
}
