package com.codesmart.myproj.controller;

import com.codesmart.myproj.entity.Product;
import com.codesmart.myproj.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IproductService productService;

    @GetMapping("/display/{id}")
    public Optional<Product> getProduct(@PathVariable Long id){

        return productService.getProduct(id);
    }

    @GetMapping("/display/all")
    public List<Product> getOrder() {

        return productService.getProductList();
    }

    //delete a product
    @DeleteMapping("/delete/{id}")
    public Optional<Product> deleteProduct(@PathVariable Long id){
       return productService.deleteProduct(id);
    }
}
