package com.example.SpringBootproductfullstack.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name ="User")

public class User {

    @Column
    private String user_name;

    @Id
    @Column
    private String email_id;

    @Column
    private String password;

    @ManyToMany (fetch=FetchType.LAZY)
    @JoinTable(name ="user_products", joinColumns = @JoinColumn(name= "user_email"),
     inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Products> prod = new ArrayList<>();
    public User () {}

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
