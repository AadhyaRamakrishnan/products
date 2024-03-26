package com.example.SpringBootproductfullstack.controller;

import com.example.SpringBootproductfullstack.dto.ProductsDTO;
import com.example.SpringBootproductfullstack.model.Products;
import com.example.SpringBootproductfullstack.service.ProductsService;
import org.modelmapper.ModelMapper;
 import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    public ResponseEntity<?> saveProducts(@RequestBody ProductsDTO productsDTO) {
        Products products = modelMapper.map(productsDTO, Products.class);
        productsService.save(products);
        Map<String, Object> rmp = new LinkedHashMap<>();
        rmp.put("status", 203);
        rmp.put("message", "Product Record Inserted Successfully");
        return new ResponseEntity<>(rmp, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        List<Products> listOfAllProducts = productsService.getAllProductsList();
        List<ProductsDTO> listOfProductsDTO = new ArrayList<>();
        Map<String, Object> jsonrmp = new LinkedHashMap<>();
        if (!listOfAllProducts.isEmpty()) {
            for (Products products : listOfAllProducts) {
                listOfProductsDTO.add(modelMapper.map(products, ProductsDTO.class));
            }
            jsonrmp.put("status", 203);
            jsonrmp.put("data", listOfProductsDTO);
            return new ResponseEntity<>(jsonrmp, HttpStatus.OK);
        } else {
            jsonrmp.clear();
            jsonrmp.put("status", 0);
            jsonrmp.put("data", "Data Not Found");
            return new ResponseEntity<>(jsonrmp, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/{name}")
    public ResponseEntity<?> getProductsByName(@PathVariable String name) {

        Map<String, Object> jsonrmp = new LinkedHashMap<>();
        Products products = productsService.findProductsByName(name);
        ProductsDTO productsDTO = modelMapper.map(products, ProductsDTO.class);
        jsonrmp.put("status", 203);
        jsonrmp.put("data", jsonrmp);
        return new ResponseEntity<>(jsonrmp, HttpStatus.OK);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<?> updateProducts(@PathVariable String name, @RequestBody ProductsDTO productsDTO) {
        try {
            Products products = productsService.findProductsByName(name);
            products.setName(productsDTO.getName());
            products.setDescription(productsDTO.getDescription());
           products.setImagePath(productsDTO.getImagePath());
            products.setDescription(productsDTO.getDescription());
            products.setPrice(productsDTO.getPrice());
            products.setQuantity(productsDTO.getPrice());
            products.setSize(productsDTO.getSize());
            products.setColourway(productsDTO.getColourway());
            products.setBrand(productsDTO.getBrand());
            productsService.save(products);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Product Name Not Found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteUser(@PathVariable String name){
        try{
            Products products= productsService.findProductsByName(name);
            productsService.delete(products);
            return new ResponseEntity<>("Product Record Deleted",HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>("Product Data Not Found", HttpStatus.NOT_FOUND);
        }
    }
}




