package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findById(int theId);

    Users save(Users users);

    void deleteById (int theId);
}
