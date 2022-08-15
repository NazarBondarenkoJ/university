package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "ratings")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<CourseRating> ratings = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_student")
    private Teacher teacher;
}
