package com.example.university.bootstrap;

import com.example.university.model.*;
import com.example.university.service.UniversityDAOService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapLoader implements CommandLineRunner {

    private final UniversityDAOService universityDAOService;

    public BootStrapLoader(UniversityDAOService universityDAOService) {
        this.universityDAOService = universityDAOService;
    }

    @Override
    public void run(String... args) {
        Student student = new Student();
        student.setFirstName("Nazar");
        student.setLastName("Bondarenko");

        Book book = new Book();
        book.setTitle("Book 1");

        Course course = new Course();
        CourseRating rating = new CourseRating();
        rating.setStudent(student);
        rating.setCourse(course);
        rating.setRating(5);

        Assistant assistant = new Assistant();
        assistant.setRole("Attorney");

        Teacher teacher = new Teacher();
        teacher.setTitle("PhD");
        teacher.setLastName("Hawking");
        teacher.setFirstName("Stephen");
        teacher.getCourses().add(course);
        teacher.getStudents().add(student);
        teacher.setAssistant(assistant);
        assistant.setTeacher(teacher);
        course.setTeacher(teacher);

        student.getRatings().add(rating);
        student.getBooks().add(book);
        student.setTeacher(teacher);

        universityDAOService.saveStudent(student);
    }
}
