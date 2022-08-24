package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(exclude = "student", callSuper = false)
public class Diploma {

    @Id
    @GeneratedValue
    private int id;

    private String topic;

    private String subject;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;
}
