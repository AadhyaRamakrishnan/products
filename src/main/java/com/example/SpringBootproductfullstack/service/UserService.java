package com.example.SpringBootproductfullstack.service;

import com.example.SpringBootproductfullstack.model.User;

import java.util.List;

public interface UserService {
 public List<User> getAllUsersList();
 public User findUserByEmailId (String email_id);
   public void saveuser(User user);

   public void deleteuser(User user);
}
