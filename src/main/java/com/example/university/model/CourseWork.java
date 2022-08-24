package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(exclude = "semester", callSuper = false)
public class CourseWork extends Diploma {

    private int semester;

}
