package com.example.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "teacher", callSuper = false)
public class Assistant extends Person{

    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
}
