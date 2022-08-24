package com.example.university.model.courses;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(exclude = "location", callSuper = false)
@DiscriminatorValue("Practical")
public class PracticalCourse extends Course {
    private String location;
}
