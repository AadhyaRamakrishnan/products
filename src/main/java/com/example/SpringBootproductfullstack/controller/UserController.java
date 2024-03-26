package com.example.SpringBootproductfullstack.controller;

import com.example.SpringBootproductfullstack.dto.ProductsDTO;
import com.example.SpringBootproductfullstack.dto.UserDTO;
import com.example.SpringBootproductfullstack.model.Products;
import com.example.SpringBootproductfullstack.model.User;
import com.example.SpringBootproductfullstack.service.ProductsService;
import com.example.SpringBootproductfullstack.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/saveuser")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
       User user = modelMapper.map(userDTO, User.class);
        userService.saveuser(user);
        Map<String, Object> rmp = new LinkedHashMap<>();
        rmp.put("status", 203);
        rmp.put("message", "User Record Inserted Successfully");
        return new ResponseEntity<>(rmp, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        List<User> listOfAllUsers = userService.getAllUsersList();
        List<UserDTO> listOfUsersDTO = new ArrayList<>();
        Map<String, Object> jsonrmp = new LinkedHashMap<>();
        if (!listOfAllUsers.isEmpty()) {
            for (User user : listOfAllUsers) {
                listOfUsersDTO.add(modelMapper.map(user, UserDTO.class));
            }
            jsonrmp.put("status", 203);
            jsonrmp.put("data", listOfUsersDTO);
            return new ResponseEntity<>(jsonrmp, HttpStatus.OK);
        } else {
            jsonrmp.clear();
            jsonrmp.put("status", 0);
            jsonrmp.put("data", "Data Not Found");
            return new ResponseEntity<>(jsonrmp, HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update/{email_id}")
    public ResponseEntity<?> updateUser(@PathVariable String email_id, @RequestBody UserDTO userDTO) {
        try {
           User user = userService.findUserByEmailId(email_id);
            user.setEmail_id(userDTO.getEmail_id());
            user.setUser_name(userDTO.getUser_name());
            user.setPassword(userDTO.getPassword());
            userService.saveuser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("User Name Not Found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{email_id}")
    public ResponseEntity<?> deleteUser(@PathVariable String email_id){
        try{
            User user= userService.findUserByEmailId(email_id);
            userService.deleteuser(user);
            return new ResponseEntity<>("User Record Deleted",HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>("User Data Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
