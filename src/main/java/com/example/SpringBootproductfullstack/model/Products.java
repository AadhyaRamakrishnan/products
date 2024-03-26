package com.example.SpringBootproductfullstack.model;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="imagePath")
    private String imagePath;
    @Column(name="price")
    private int price;
    @Column(name="quantity")
    private int quantity;
    @Column(name="size")
    private float size;
    @Column(name="colourway")
    private String colourway;
    @Column(name="brand")
    private String brand;

    public Products() {
    }


    public Products(String name, String description, String imagePath, int price, int quantity, float size, String colourway,String brand) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.colourway = colourway;
        this.brand= brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getColourway() {
        return colourway;
    }

    public void setColourway(String colourway) {
        this.colourway = colourway;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
