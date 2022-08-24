package com.example.university.model.courses;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CourseRatingKey implements Serializable {

    @Column
    int studentId;

    @Column
    int courseId;
}
