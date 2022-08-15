package com.example.university.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String title;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private List<Student> student = new ArrayList<>();
}
