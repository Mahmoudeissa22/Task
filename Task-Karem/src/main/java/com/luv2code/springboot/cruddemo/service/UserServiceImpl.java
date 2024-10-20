package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.UserRepository;
import com.luv2code.springboot.cruddemo.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(int theId) {
        Optional<Users> result = userRepository.findById(theId);
        Users theUser = null;
        if (result.isPresent()){
            theUser = result.get();
        }else {
            throw new RuntimeException("It is not found " + theId);
        }
        return theUser;
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void deleteById(int theId) {

        userRepository.deleteById(theId);
    }
}
