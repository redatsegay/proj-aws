package com.codesmart.myproj.service;

import com.codesmart.myproj.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IproductService {
    public Optional<Product> getProduct(Long id);
    public List<Product> getProductList();
    public Optional<Product> deleteProduct(Long id);
}
