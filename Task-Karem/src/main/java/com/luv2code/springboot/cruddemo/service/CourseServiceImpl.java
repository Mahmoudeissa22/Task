package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.CourseRepository;
import com.luv2code.springboot.cruddemo.entity.Courses;
import com.luv2code.springboot.cruddemo.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Courses> findAllcourse() {
        return List.of();
    }

    @Override
    public Courses findcourseById(int theId) {
        return null;
    }

    @Override
    public Courses savecourse(Users users) {
        return null;
    }

    @Override
    public void deletecourseById(int theId) {

    }
}
