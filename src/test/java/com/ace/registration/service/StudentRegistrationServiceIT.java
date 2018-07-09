package com.ace.registration.service;

import com.ace.registration.model.Course;
import com.ace.registration.model.CourseId;
import com.ace.registration.model.Student;
import com.ace.registration.model.StudentId;
import com.example.demo.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class})
public class StudentRegistrationServiceIT {

    @Autowired
    StudentRegistrationService studentRegistrationService;

    @Test
    public void testStudentService(){
        Course course=new Course();
        course.setCourseId(new CourseId(1L));
        course.setCourseName("something");
        course.setFee(1200);
        Student student=new Student();
        student.setStudentName("ma");
        student.setStudentId(new StudentId(1L));
        studentRegistrationService.stdentReistration(course,student);
    }
}
