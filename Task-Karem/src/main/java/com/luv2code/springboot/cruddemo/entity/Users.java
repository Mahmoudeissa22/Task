package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private  String email;

    @ManyToMany(fetch = FetchType.LAZY ,
            cascade = {CascadeType.DETACH ,CascadeType.MERGE ,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Courses> courses;

    public Users() {
    }

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addCourse(Courses thecourse) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(thecourse);
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
