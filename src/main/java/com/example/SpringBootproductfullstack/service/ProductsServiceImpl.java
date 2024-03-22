package com.example.SpringBootproductfullstack.service;

import com.example.SpringBootproductfullstack.model.Products;
import com.example.SpringBootproductfullstack.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
@Autowired
private ProductsRepository productsRepository;
    @Override
    public List<Products> getAllProductsList() {
        return productsRepository.findAll();
    }

    @Override
    public void save(Products products) {
      productsRepository.save(products);
    }

    @Override
    public  Products findProductsByName(String name) {
        return productsRepository.searchByName(name);
    }

    @Override
    public void delete(Products products) {

    }
}
