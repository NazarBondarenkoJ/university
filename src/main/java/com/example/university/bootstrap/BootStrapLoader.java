package com.example.university.bootstrap;

import com.example.university.model.*;
import com.example.university.model.courses.CourseRating;
import com.example.university.model.courses.PracticalCourse;
import com.example.university.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapLoader implements CommandLineRunner {

    private final StudentService studentService;

    public BootStrapLoader(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) {
        Student student = new Student();
        student.setFirstName("Nazar");
        student.setLastName("Bondarenko");

        Book book = new Book();
        book.setTitle("Book 1");

        PracticalCourse course = new PracticalCourse();
        CourseRating rating = new CourseRating();
        course.setLocation("Main Building");
        rating.setStudent(student);
        rating.setCourse(course);
        rating.setRating(5);

        Assistant assistant = new Assistant();
        assistant.setRole(Role.MAIN_ASSISTANT);
        assistant.setLastName("AssistantLastName");
        assistant.setFirstName("AssistantFirstName");

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
        student.setCourse(course);
        course.getStudents().add(student);

        Diploma diploma = new Diploma();
        diploma.setStudent(student);
        diploma.setSubject("Imperative Programming");
        diploma.setTopic("Python. SciPy");

        CourseWork courseWork = new CourseWork();
        courseWork.setSemester(1);
        courseWork.setTopic("Differential equations");
        courseWork.setSubject("Math");
        courseWork.setStudent(student);

        student.setDiploma(diploma);
        student.setCourseWork(courseWork);

        studentService.addStudent(student);

    }
}
