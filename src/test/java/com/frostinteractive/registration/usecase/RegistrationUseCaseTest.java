package com.frostinteractive.registration.usecase;

import com.frostinteractive.registration.model.*;
import com.frostinteractive.config.AppConfig;
import lombok.val;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class})
public class RegistrationUseCaseTest {
    @Autowired
    private RegistrationUseCase registrationUseCase;
    @Test
    public void courseRegistrationsLessThan10(){
        Course course=new Course();
        course.setCourseId(new CourseId(1L));
        course.setCourseName("science 101");

        Student student=new Student();
        student.setStudentId(new StudentId(7L));
        student.setStudentName("satya");


        List<StudentRegistration> studentRegistrationList=LongStream.rangeClosed(1,5).mapToObj(x->{

            StudentRegistration studentRegistration=new StudentRegistration();
            studentRegistration.setStudentId(new StudentId(x));

            List<Registration> registrationList=LongStream.rangeClosed(1L,4L).mapToObj(y->{
                val registrations=new Registration();
                registrations.setRegistrationId(new RegistrationId(y));
                registrations.setStudentId(studentRegistration.getStudentId());
                registrations.setCourseId(new CourseId(y));
                registrations.setRegistrationState(RegistrationState.APPROVED);
                return registrations;
            }).collect(Collectors.toList());

            studentRegistration.setRegistrations(registrationList);
            return studentRegistration;

        }).collect(Collectors.toList());

        val registrations1=registrationUseCase.registerStudent(course,student,studentRegistrationList);
        assertTrue(registrations1.isRight());
        assertEquals(RegistrationState.APPROVED,registrations1.get().getRegistrations().
                stream().filter(x->x.getCourseId().equals(course.getCourseId())).findAny().get().getRegistrationState());

    }
    @Test
    public void courseRegistrationsGreaterThan10(){
        Course course=new Course();
        course.setCourseId(new CourseId(1L));
        course.setCourseName("science 101");

        Student student=new Student();
        student.setStudentId(new StudentId(11L));
        student.setStudentName("satya");



        List<StudentRegistration> studentRegistrationList=LongStream.rangeClosed(1,10).mapToObj(x->{

            StudentRegistration studentRegistration=new StudentRegistration();
            studentRegistration.setStudentId(new StudentId(x));

            List<Registration> registrationList=LongStream.rangeClosed(1L,4L).mapToObj(y->{
                val registrations=new Registration();
                registrations.setRegistrationId(new RegistrationId(y));
                registrations.setStudentId(studentRegistration.getStudentId());
                registrations.setCourseId(new CourseId(y));
                registrations.setRegistrationState(RegistrationState.APPROVED);
                return registrations;
            }).collect(Collectors.toList());

            studentRegistration.setRegistrations(registrationList);
            return studentRegistration;

        }).collect(Collectors.toList());



        val registrations1=registrationUseCase.registerStudent(course,student,studentRegistrationList);
        assertTrue(registrations1.isRight());
        assertEquals(RegistrationState.WAITING,registrations1.get().getRegistrations().
                stream().filter(x->x.getCourseId().equals(course.getCourseId())).findAny().get().getRegistrationState());

    }
    @Test
    public void studentRegistrationLessThan5(){
        Course course=new Course();
        course.setCourseId(new CourseId(5L));
        course.setCourseName("science 101");

        Student student=new Student();
        student.setStudentId(new StudentId(1L));
        student.setStudentName("satya");



        List<StudentRegistration> studentRegistrationList=LongStream.rangeClosed(1,8).mapToObj(x->{

            StudentRegistration studentRegistration=new StudentRegistration();
            studentRegistration.setStudentId(new StudentId(x));

            List<Registration> registrationList=LongStream.rangeClosed(1L,4L).mapToObj(y->{
                val registrations=new Registration();
                registrations.setRegistrationId(new RegistrationId(y));
                registrations.setStudentId(studentRegistration.getStudentId());
                registrations.setCourseId(new CourseId(y));
                registrations.setRegistrationState(RegistrationState.APPROVED);
                return registrations;
            }).collect(Collectors.toList());

            studentRegistration.setRegistrations(registrationList);
            return studentRegistration;

        }).collect(Collectors.toList());




        val registrations1=registrationUseCase.registerStudent(course,student,studentRegistrationList);
        assertTrue(registrations1.isRight());


    }
    @Test
    public void studentRegistrationGreaterThan5(){
        Course course=new Course();
        course.setCourseId(new CourseId(6L));
        course.setCourseName("science 101");

        Student student=new Student();
        student.setStudentId(new StudentId(1L));
        student.setStudentName("satya");

        List<StudentRegistration> studentRegistrationList=LongStream.rangeClosed(1,8).mapToObj(x->{

            StudentRegistration studentRegistration=new StudentRegistration();
            studentRegistration.setStudentId(new StudentId(x));

            List<Registration> registrationList=LongStream.rangeClosed(1L,5L).mapToObj(y->{
                val registrations=new Registration();
                registrations.setRegistrationId(new RegistrationId(y));
                registrations.setStudentId(studentRegistration.getStudentId());
                registrations.setCourseId(new CourseId(y));
                registrations.setRegistrationState(RegistrationState.APPROVED);
                return registrations;
            }).collect(Collectors.toList());

            studentRegistration.setRegistrations(registrationList);
            return studentRegistration;

        }).collect(Collectors.toList());

        val registrations1=registrationUseCase.registerStudent(course,student,studentRegistrationList);
        assertTrue(registrations1.isLeft());
    }

    private void sample(){}
}
