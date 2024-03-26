package com.example.SpringBootproductfullstack.service;

import com.example.SpringBootproductfullstack.model.User;
import com.example.SpringBootproductfullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsersList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmailId(String email_id) {
        return userRepository.searchByEmailId(email_id);
    }

    @Override
    public void saveuser(User user) {
       userRepository.save(user);
    }

    @Override
    public void deleteuser(User user) {

    }
}

