package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "assistant")
public class Teacher {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private String title;

    @Column(name = "teacher_student")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Student> students = new ArrayList<>();

    @Column(name = "teacher_course")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Assistant assistant;
}
