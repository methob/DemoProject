package com.jonathan.test.demo.controller;

import com.jonathan.test.demo.entity.Product;
import com.jonathan.test.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Product")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "show all product")
    public List<Product> listAll(){
        return productService.listAll();
    }


}
