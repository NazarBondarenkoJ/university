package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "teacher")
public class Assistant {

    @Id
    @GeneratedValue
    private int id;

    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
}
