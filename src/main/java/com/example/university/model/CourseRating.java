package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
public class CourseRating {

    @EmbeddedId
    CourseRatingKey id = new CourseRatingKey();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    int rating;
}
