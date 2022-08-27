package com.example.university.service;

import com.example.university.model.Student;
import com.example.university.model.Teacher;
import com.example.university.repository.UniversityDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final UniversityDAO<Teacher> teacherUniversityDAO;

    public TeacherService(UniversityDAO<Teacher> teacherUniversityDAO) {
        this.teacherUniversityDAO = teacherUniversityDAO;
        teacherUniversityDAO.setSelectedClass(Teacher.class);
    }

    public List<Teacher> findAllTeachers() {
        return teacherUniversityDAO.getAll();
    }

    public Teacher findTeacherById(int id) {
        return teacherUniversityDAO.get(id);
    }

    public void addStudentToTeacher(int teacherId, Student student) {
        Teacher teacher = findTeacherById(teacherId);
        teacher.getStudents().add(student);
        teacherUniversityDAO.update(teacher);
    }

    public void deleteTeacherById(int teacherId) {
        teacherUniversityDAO.delete(findTeacherById(teacherId));
    }
}
