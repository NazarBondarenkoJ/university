package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"ratings", "teacher"})
public class Course {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    Set<CourseRating> ratings = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_teacher")
    private Teacher teacher;
}
