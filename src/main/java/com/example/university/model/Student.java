package com.example.university.model;

import com.example.university.model.courses.Course;
import com.example.university.model.courses.CourseRating;
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
@EqualsAndHashCode(exclude = {"ratings", "course"}, callSuper = false)
@ToString(exclude = {"books", "ratings", "teacher", "course", "diploma", "courseWork"})
public class Student extends Person{

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<CourseRating> ratings = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_student")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    private Diploma diploma;

    @OneToOne(cascade = CascadeType.ALL)
    private CourseWork courseWork;
}
