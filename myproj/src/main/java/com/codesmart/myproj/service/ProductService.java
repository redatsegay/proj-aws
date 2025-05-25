package com.codesmart.myproj.service;


import com.codesmart.myproj.entity.Product;
import com.sun.jdi.LongValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> productList = new ArrayList<>(
            Arrays.asList(
                    new Product(1L,"Grape","This is a very nice grape"),
                    new Product(2L,"Banana","This is a very nice Banana"),
                    new Product(3L,"Orange","This is a very nice Orange")

            ));

    //return a product by id
    public Product getProduct(Long id){
        return productList.get(id.intValue());
    }

    public List<Product> getProductList(){
        return productList;
    }
}
