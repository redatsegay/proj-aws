package com.codesmart.myproj.service;


import com.codesmart.myproj.entity.Product;
import com.sun.jdi.LongValue;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    List<Product> productList = new ArrayList<>(
            Arrays.asList(
                    new Product(1L,"Grape","This is a very nice grape"),
                    new Product(2L,"Banana","This is a very nice Banana"),
                    new Product(3L,"Orange","This is a very nice Orange")

            ));

    //return a product by id
    public Optional<Product> getProduct(Long id){
        if(id >= productList.size())
            throw new NullPointerException("value with id does not exist");

        return Optional.of(productList.get(id.intValue()));
    }

    public List<Product> getProductList(){
        return productList;
    }

    //delete a product
    public void deleteProduct(Long id){
        if(id >= productList.size())
            throw new RuntimeException("Product with a given id does not exist");

        productList.remove(id.longValue());
        System.out.println("Product removed from the list");
    }
}
