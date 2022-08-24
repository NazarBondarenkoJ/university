package com.example.university.model.courses;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(exclude = "material", callSuper = false)
@DiscriminatorValue("Theoretical")
public class TheoreticalCourse extends Course {
    private String material;
}
