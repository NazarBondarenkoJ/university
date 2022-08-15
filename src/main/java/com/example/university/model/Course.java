package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"ratings", "teacher"})
public class Course {

    @Id
    @GeneratedValue()
    private int id;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    Set<CourseRating> ratings = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_teacher")
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Student> students = new ArrayList<>();
}
