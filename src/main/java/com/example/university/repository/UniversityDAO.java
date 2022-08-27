package com.example.university.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Data
public class UniversityDAO<T> {

    private Class<T> selectedClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public T get(int id) {
        return entityManager.find(selectedClass, id);
    }

    @Transactional
    public List<T> getAll() {
        return entityManager.createQuery("from " + selectedClass.getName(),selectedClass).getResultList();
    }

    @Transactional
    public void save(T t) {
        entityManager.persist(t);
    }

    @Transactional
    public void update(T t) {
        entityManager.merge(t);
    }

    @Transactional
    public void delete(T t) {
        entityManager.remove(t);
    }
}
