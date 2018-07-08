package com.ace.registration.service;

import com.ace.registration.infrastructure.StudentRegistrationRepo;
import com.ace.registration.model.*;
import com.example.demo.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class})
public class StudentRegistrationServiceIT {

    @Autowired
    StudentRegistrationService studentRegistrationService;

    @Autowired
    StudentRegistrationRepo registrationRepo;

    @Test
    public void testStudentService(){
        Course course=new Course();
        course.setCourseId(new CourseId(1L));
        course.setCourseName("something");
        course.setFee(1200);
        Student student=new Student();
        student.setStudentName("ma");
        student.setStudentId(new StudentId(1L));
        studentRegistrationService.addStudentRegistration(course,student);
    }

    @Test
    public void saveStudentRegTest(){
        StudentId studentId = new StudentId(1l);

        Registration registration1 = new Registration();
        registration1.setRegistrationId(new RegistrationId(1l));
        registration1.setStudentId(studentId);
        registration1.setCourseId(new CourseId(1l));
        registration1.setRegistrationState(RegistrationState.WAITING);

        Registration registration2 = new Registration();
        registration2.setRegistrationId(new RegistrationId(2l));
        registration2.setStudentId(studentId);
        registration2.setCourseId(new CourseId(2l));
        registration2.setRegistrationState(RegistrationState.WAITING);

        Registration registration3 = new Registration();
        registration3.setRegistrationId(new RegistrationId(3l));
        registration3.setStudentId(studentId);
        registration3.setCourseId(new CourseId(3l));
        registration3.setRegistrationState(RegistrationState.WAITING);

        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.setStudentId(studentId);
        studentRegistration.setRegistrations(Arrays.asList(registration1,registration2,registration3));

        registrationRepo.save(studentRegistration);
    }


}
