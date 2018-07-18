package com.frostinteractive.payment.usecase;

import com.frostinteractive.payment.model.Payment;
import com.frostinteractive.payment.model.PaymentId;
import com.frostinteractive.payment.model.PaymentState;
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
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class})
public class StudentRegistrationUseCaseTest {

    @Autowired
    StudentRegistrationUseCase studentRegistrationUseCase;

//    @Test
//    public void paymentSuccessTest() {
//        Student student=new Student();
//        student.setStudentId(new StudentId(1L));
//        student.setStudentName("some");
//        List<Course> courseList = LongStream.rangeClosed(1, 5).mapToObj(x -> {
//            Course course = new Course();
//            course.setCourseId(new CourseId(100 + x));
//            course.setFee((int) x + 500);
//            return course;
//        }).collect(Collectors.toList());
//
//        List<Registration> registrationList = LongStream.rangeClosed(1, 5).mapToObj(x -> {
//            Registration registration = new Registration();
//            registration.setRegistrationId(new RegistrationId(x));
//            registration.setRegistrationState(RegistrationState.APPROVED);
//            registration.setCourseId(new CourseId(100 + x));
//            registration.setStudentId(student.getStudentId());
//            return registration;
//
//        }).collect(Collectors.toList());
//
//
//        Payment payment=new Payment();
//        payment.setPaymentId(new PaymentId(1L));
//        payment.setPaymentState(PaymentState.SUCCESS);
//
//        StudentRegistration studentRegistration=new StudentRegistration();
//        studentRegistration.setStudentId(student.getStudentId());
//        studentRegistration.setRegistrations(registrationList);
//
//        val studentRegistration1=studentRegistrationUseCase.payForStudentCourses(payment,studentRegistration,
//                registrationList.stream().map(x->x.getRegistrationId()).collect(Collectors.toList()),courseList);
//
//
//        assertEquals(PaymentState.SUCCESS,studentRegistration1.findById(new PaymentId(1L)).get().getPaymentState());
//
//
//        assertEquals(5, studentRegistration1.getRegistrations().stream()
//                .map(x -> x.getRegistrationState())
//                .filter(x ->x.equals(RegistrationState.CONFIRMED)).count(), () -> "5 courses should be confirmed");
//
//    }
//
//    @Test
//    public void paymentFailTest() {
//        Student student=new Student();
//        student.setStudentId(new StudentId(1L));
//        student.setStudentName("some");
//        List<Course> courseList = LongStream.rangeClosed(1, 5).mapToObj(x -> {
//            Course course = new Course();
//            course.setCourseId(new CourseId(100 + x));
//            course.setFee((int) x + 500);
//            return course;
//        }).collect(Collectors.toList());
//
//        List<Registration> registrationList = LongStream.rangeClosed(1, 5).mapToObj(x -> {
//            Registration registration = new Registration();
//            registration.setRegistrationId(new RegistrationId(x));
//            registration.setRegistrationState(RegistrationState.APPROVED);
//            registration.setCourseId(new CourseId(100 + x));
//            registration.setStudentId(student.getStudentId());
//            return registration;
//
//        }).collect(Collectors.toList());
//
//
//        Payment payment=new Payment();
//        payment.setPaymentId(new PaymentId(1L));
//        payment.setPaymentState(PaymentState.FAIL);
//
//        StudentRegistration studentRegistration=new StudentRegistration();
//        studentRegistration.setStudentId(student.getStudentId());
//        studentRegistration.setRegistrations(registrationList);
//
//        val studentRegistration1=studentRegistrationUseCase.payForStudentCourses(payment,studentRegistration,
//                registrationList.stream().map(x->x.getRegistrationId()).collect(Collectors.toList()),courseList);
//
//        assertEquals(PaymentState.FAIL,studentRegistration1.findById(new PaymentId(1L)).get().getPaymentState());
//        assertEquals(5, studentRegistration1.getRegistrations().stream()
//                .map(x -> x.getRegistrationState())
//                .filter(x -> x == RegistrationState.APPROVED).count(), () -> "5 courses should be confirmed");
//
//    }
//
//    @Test
//    public void paymentSuccessOnlyForApproved() {
//        Student student=new Student();
//        student.setStudentId(new StudentId(1L));
//        student.setStudentName("some");
//        List<Course> courseList = LongStream.rangeClosed(1, 5).mapToObj(x -> {
//            Course course = new Course();
//            course.setCourseId(new CourseId(100 + x));
//            course.setFee((int) x + 500);
//            return course;
//        }).collect(Collectors.toList());
//
//       val registrationStream1 = LongStream.rangeClosed(1, 3).mapToObj(x -> {
//            Registration registration = new Registration();
//            registration.setRegistrationId(new RegistrationId(x));
//            registration.setRegistrationState(RegistrationState.APPROVED);
//            registration.setCourseId(new CourseId(100 + x));
//            registration.setStudentId(student.getStudentId());
//            return registration;
//
//        });
//        val registrationStream2 = LongStream.rangeClosed(4, 5).mapToObj(x -> {
//            Registration registration = new Registration();
//            registration.setRegistrationId(new RegistrationId(x));
//            registration.setRegistrationState(RegistrationState.WAITING);
//            registration.setCourseId(new CourseId(100 + x));
//            registration.setStudentId(student.getStudentId());
//            return registration;
//
//        });
//        val registrationList=Stream.concat(registrationStream1,registrationStream2).
//                collect(Collectors.toList());
//
//
//        Payment payment=new Payment();
//        payment.setPaymentId(new PaymentId(1L));
//        payment.setPaymentState(PaymentState.SUCCESS);
//
//        StudentRegistration studentRegistration=new StudentRegistration();
//        studentRegistration.setStudentId(student.getStudentId());
//        studentRegistration.setRegistrations(registrationList);
//
//        val studentRegistration1=studentRegistrationUseCase.payForStudentCourses(payment,studentRegistration,
//                registrationList.stream().map(x->x.getRegistrationId()).collect(Collectors.toList()),courseList);
//
//        assertEquals(PaymentState.SUCCESS,studentRegistration1.findById(new PaymentId(1L)).get().getPaymentState());
//        assertEquals(3, studentRegistration1.getRegistrations().stream()
//                .map(x -> x.getRegistrationState())
//                .filter(x -> x == RegistrationState.CONFIRMED).count(), () -> "5 courses should be confirmed");
//
//
//    }
//    @Test
//    public void paymentFailOnlyForApproved() {
//        Student student=new Student();
//        student.setStudentId(new StudentId(1L));
//        student.setStudentName("some");
//        List<Course> courseList = LongStream.rangeClosed(1, 5).mapToObj(x -> {
//            Course course = new Course();
//            course.setCourseId(new CourseId(100 + x));
//            course.setFee((int) x + 500);
//            return course;
//        }).collect(Collectors.toList());
//
//        val registrationStream1 = LongStream.rangeClosed(1, 3).mapToObj(x -> {
//            Registration registration = new Registration();
//            registration.setRegistrationId(new RegistrationId(x));
//            registration.setRegistrationState(RegistrationState.APPROVED);
//            registration.setCourseId(new CourseId(100 + x));
//            registration.setStudentId(student.getStudentId());
//            return registration;
//
//        });
//        val registrationStream2 = LongStream.rangeClosed(4, 5).mapToObj(x -> {
//            Registration registration = new Registration();
//            registration.setRegistrationId(new RegistrationId(x));
//            registration.setRegistrationState(RegistrationState.WAITING);
//            registration.setCourseId(new CourseId(100 + x));
//            registration.setStudentId(student.getStudentId());
//            return registration;
//
//        });
//        List<Registration> registrationList=Stream.concat(registrationStream1,registrationStream2).
//                collect(Collectors.toList());
//
//
//        Payment payment=new Payment();
//        payment.setPaymentId(new PaymentId(1L));
//        payment.setPaymentState(PaymentState.FAIL);
//
//        StudentRegistration studentRegistration=new StudentRegistration();
//        studentRegistration.setStudentId(student.getStudentId());
//        studentRegistration.setRegistrations(registrationList);
//
//        val studentRegistration1=studentRegistrationUseCase.payForStudentCourses(payment,studentRegistration,
//                registrationList.stream().map(x->x.getRegistrationId()).collect(Collectors.toList()),courseList);
//
//        assertEquals(PaymentState.FAIL,studentRegistration1.findById(new PaymentId(1L)).get().getPaymentState());
//        assertEquals(3, studentRegistration1.getRegistrations().stream()
//                .map(x -> x.getRegistrationState())
//                .filter(x -> x == RegistrationState.APPROVED).count(), () -> "5 courses should be confirmed");
//
//
//    }


}
