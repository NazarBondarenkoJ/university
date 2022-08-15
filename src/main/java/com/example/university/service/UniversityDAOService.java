package com.example.university.service;

import com.example.university.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UniversityDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveStudent(Student student) {
        entityManager.persist(student);
    }
}
