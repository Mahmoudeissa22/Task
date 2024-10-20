package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Courses;
import com.luv2code.springboot.cruddemo.entity.Users;

import java.util.List;

public interface CourseService {

    List<Courses> findAllcourse();

    Courses findcourseById(int theId);

    Courses savecourse(Users users);

    void deletecourseById (int theId);
}
