package com.example.SpringBootproductfullstack.service;
import com.example.SpringBootproductfullstack.model.Products;

import java.util.*;
public interface ProductsService {
    public List<Products> getAllProductsList();
    public void save(Products products);
    public  Products findProductsByName(String name);
    public void delete(Products products);

}
