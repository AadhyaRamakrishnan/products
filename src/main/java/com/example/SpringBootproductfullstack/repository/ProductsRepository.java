package com.example.SpringBootproductfullstack.repository;

import com.example.SpringBootproductfullstack.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
  public Products searchByName(@Param("name") String name);
}
