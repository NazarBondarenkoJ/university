package com.example.university.bootstrap;

import com.example.university.model.*;
import com.example.university.model.courses.CourseRating;
import com.example.university.model.courses.PracticalCourse;
import com.example.university.repository.UniversityDAO;
import com.example.university.service.StudentService;
import net.sf.ehcache.CacheManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapLoader implements CommandLineRunner {

    //Added only in scope of the task. Should be removed after.
    @Autowired
    private UniversityDAO<Student> universityDAO;

    private final StudentService studentService;

    public BootStrapLoader(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) {
        for (int i = 1; i < 3; i++) {
            Student student = new Student();
            student.setFirstName("Student: " + i);
            student.setLastName("Last Name: " + i);

            Book book = new Book();
            book.setTitle("Book: " + i);

            PracticalCourse course = new PracticalCourse();
            CourseRating rating = new CourseRating();
            course.setLocation("Main Building");
            rating.setStudent(student);
            rating.setCourse(course);
            rating.setRating(5);

            Assistant assistant = new Assistant();
            assistant.setRole(Role.MAIN_ASSISTANT);
            assistant.setLastName("AssistantLastName " + i);
            assistant.setFirstName("AssistantFirstName " + i);

            Teacher teacher = new Teacher();
            teacher.setTitle("PhD");
            teacher.setLastName("Teacher: " + i);
            teacher.setFirstName("Teacher Last Name: " + i);
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
            diploma.setSubject("Imperative Programming " + i);
            diploma.setTopic("Python. SciPy " + i);

            CourseWork courseWork = new CourseWork();
            courseWork.setSemester(1);
            courseWork.setTopic("Differential equations " + i);
            courseWork.setSubject("Math " + i);
            courseWork.setStudent(student);

            student.setDiploma(diploma);
            student.setCourseWork(courseWork);

            studentService.addStudent(student);
        }

        Session session = universityDAO.getEntityManager().unwrap(Session.class);
        SessionFactory sessionFactory = session.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        session1.createQuery("from " + Student.class.getName(),Student.class).getResultList();
        Session session2 = sessionFactory.openSession();
        session2.createQuery("from " + Student.class.getName(),Student.class).getResultList();

        System.out.println(CacheManager.ALL_CACHE_MANAGERS);
    }
}
