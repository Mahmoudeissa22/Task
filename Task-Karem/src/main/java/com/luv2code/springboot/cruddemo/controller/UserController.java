package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Users;
import com.luv2code.springboot.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> findUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public Users getUser(@PathVariable int userId){
        Users theUser = userService.findById(userId);
        if (theUser == null){
            throw new RuntimeException("User is not found" + userId);
        }
        return theUser;
    }

    @PostMapping("/users")
    public Users addUser(@RequestBody Users users){
        users.setId(0);
        Users dbUser = userService.save(users);
        return dbUser;
    }

    @PutMapping("/users")
    public Users upDate (@RequestBody Users users){
        Users dbUser = userService.save(users);
        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser (@PathVariable int userId){

        Users theUser = userService.findById(userId);
        if (theUser == null){
            throw new RuntimeException("User is not found" + userId);
        }
        userService.deleteById(userId);
        return "Delete User: " +userId;
    }


}
