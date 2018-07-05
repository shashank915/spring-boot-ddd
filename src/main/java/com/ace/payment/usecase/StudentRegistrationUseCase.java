package com.ace.payment.usecase;

import com.ace.payment.model.Payment;
import com.ace.registration.model.*;

import io.vavr.Tuple2;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentRegistrationUseCase {

    public StudentRegistration payForStudentCourses(Payment payment,
                                                                   StudentRegistration studentRegistration,
                                                                   List<RegistrationId> registrationIds,
                                                                   List<Course> courseList);




}
