package org.example.springjdbc;

import org.example.springjdbc.model.Student;
import org.example.springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
        Student s = context.getBean(Student.class);
        s.setRollNo(104);
        s.setName("Raj");
        s.setMarks(96);
        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> studentList = service.getStudents();
        for(Student student : studentList) {
            System.out.println(student.getRollNo() + " " + student.getName() + " " + student.getMarks());
        }
    }

}
