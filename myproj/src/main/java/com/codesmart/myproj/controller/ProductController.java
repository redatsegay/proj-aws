package com.codesmart.myproj.controller;

import com.codesmart.myproj.entity.Product;
import com.codesmart.myproj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
            return productService.getProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getOrder() {
        return productService.getProductList();
    }
}
