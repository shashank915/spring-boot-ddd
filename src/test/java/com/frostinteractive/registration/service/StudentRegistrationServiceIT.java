package com.frostinteractive.registration.service;

import com.frostinteractive.registration.infrastructure.StudentRegistrationRepo;
import com.frostinteractive.registration.model.*;
import com.frostinteractive.config.AppConfig;
import lombok.val;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


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

    StudentRegistration studentRegistration;
    Registration registration1,registration2,registration3;
    StudentId studentId;

    @BeforeEach
    public void init(){
        studentId = new StudentId(1l);

        registration1 = new Registration();
        registration1.setRegistrationId(new RegistrationId(1l));
        registration1.setStudentId(studentId);
        registration1.setCourseId(new CourseId(1l));
        registration1.setRegistrationState(RegistrationState.WAITING);

        registration2 = new Registration();
        registration2.setRegistrationId(new RegistrationId(2l));
        registration2.setStudentId(studentId);
        registration2.setCourseId(new CourseId(2l));
        registration2.setRegistrationState(RegistrationState.WAITING);

        registration3 = new Registration();
        registration3.setRegistrationId(new RegistrationId(3l));
        registration3.setStudentId(studentId);
        registration3.setCourseId(new CourseId(3l));
        registration3.setRegistrationState(RegistrationState.WAITING);

        studentRegistration = new StudentRegistration();

        studentRegistration.setStudentId(studentId);
        studentRegistration.getRegistrations().add(registration1);
        studentRegistration.getRegistrations().add(registration2);
        studentRegistration.getRegistrations().add(registration3);
    }
    @Test
    @Transactional
    public void saveStudentRegTest() {
        registrationRepo.save(studentRegistration);

        val optional = registrationRepo.findById(studentId);
        Assumptions.assumeTrue(optional.isPresent());
        assertThat(optional.isPresent()).isTrue();

        StudentRegistration studentRegistration1 = optional.get();
        assertThat(studentRegistration1.getStudentId().getStudentId()).isEqualTo(studentRegistration.getStudentId().getStudentId());

        assertThat(studentRegistration1.getRegistrations().size()).isEqualTo(studentRegistration.getRegistrations().size());
    }

    @Test
    public void childEntityupdateTest(){
        registration1.setRegistrationState(RegistrationState.APPROVED);
        registration2.setRegistrationState(RegistrationState.CONFIRMED);
        registration3.setRegistrationState(RegistrationState.CANCELED);

        Registration registration4 = new Registration();
        registration4.setRegistrationId(new RegistrationId(4l));
        registration4.setStudentId(studentId);
        registration4.setCourseId(new CourseId(4l));
        registration4.setRegistrationState(RegistrationState.APPROVED);

        studentRegistration.getRegistrations().add(registration4);

        registrationRepo.save(studentRegistration);

        val optional = registrationRepo.findById(studentId);
        assertThat(optional.isPresent()).isTrue();
        StudentRegistration studentRegistration1 = optional.get();

//        assertThat(studentRegistration1.getRegistrations().size()).isEqualTo(studentRegistration.getRegistrations().size());
//        assertThat(studentRegistration1.getRegistrations().stream().filter(x->x.getRegistrationId())findAny())
    }
//
    @Test
    public void parentEntityDeleteTest(){
        registrationRepo.delete(studentRegistration);
    }

    @Test
    public void getMaxRegistrationIdTest(){
        RegistrationId registrationId = registrationRepo.getMaxRegistrationId();
        assertThat(registrationId).isNotNull();
        assertThat(registrationId).isEqualTo(new RegistrationId(4l));
    }
}
