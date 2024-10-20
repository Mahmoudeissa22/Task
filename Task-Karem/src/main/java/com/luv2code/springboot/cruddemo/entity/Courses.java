package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Courses {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "user-id")
    private int userId;



    @ManyToMany(fetch = FetchType.LAZY ,
    cascade = {CascadeType.DETACH ,CascadeType.MERGE ,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "user_course",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Users> user;

    public Courses() {
    }

    public Courses(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public List<Users> getUser() {
        return user;
    }

    public void setUser(List<Users> user) {
        this.user = user;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void addCourse(Users theUser){
        if (user == null){
            user = new ArrayList<>();
        }
        user.add(theUser);
    }
    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
