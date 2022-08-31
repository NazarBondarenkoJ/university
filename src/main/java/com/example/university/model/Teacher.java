package com.example.university.model;

import com.example.university.model.courses.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "assistant", callSuper = false)
@ToString(exclude = {"students", "courses","assistant"})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Teacher extends Person{

    private String title;

    @Column(name = "teacher_student")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Student> students = new ArrayList<>();

    @Column(name = "teacher_course")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToOne(cascade = CascadeType.ALL)
    private Assistant assistant;
}
