package com.example.university.service;

import com.example.university.model.Book;
import com.example.university.model.Student;
import com.example.university.repository.UniversityDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final UniversityDAO<Student> studentUniversityDAO;

    public StudentService(UniversityDAO<Student> studentUniversityDAO) {
        this.studentUniversityDAO = studentUniversityDAO;
        studentUniversityDAO.setSelectedClass(Student.class);
    }

    public void addStudent(Student student) {
        studentUniversityDAO.save(student);
    }

    public Student findStudentById(int id) {
        return studentUniversityDAO.get(id);
    }

    public List<Student> findAllStudent() {
        return studentUniversityDAO.getAll();
    }

    public void addBookToStudent(int studentId, Book book) {
        Student student = findStudentById(studentId);
        student.getBooks().add(book);
        studentUniversityDAO.update(student);
    }

    public void deleteStudentById(int studentId) {
        studentUniversityDAO.delete(findStudentById(studentId));
    }
}
