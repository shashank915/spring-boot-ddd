package com.frostinteractive.registration.usecase;

import com.frostinteractive.registration.model.*;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegistrationUseCase {

    public Either<Exception,StudentRegistration> registerStudent(Course course, Student student, List<StudentRegistration> studentRegistrationList);

    StudentRegistration payForStudentCourses(PaymentVO paymentVO,
                                             StudentRegistration studentRegistration);
}
