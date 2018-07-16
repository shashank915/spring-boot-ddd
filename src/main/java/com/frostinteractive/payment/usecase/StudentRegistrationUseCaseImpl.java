package com.frostinteractive.payment.usecase;

import com.frostinteractive.payment.model.Payment;
import com.frostinteractive.registration.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRegistrationUseCaseImpl implements StudentRegistrationUseCase {


    @Override
    public StudentRegistration payForStudentCourses(Payment payment,
                                                    StudentRegistration studentRegistration,
                                                    List<RegistrationId> registrationIds,
                                                    List<Course> courseList) {

        return studentRegistration.payForRegistration(payment,registrationIds);
    }
}
