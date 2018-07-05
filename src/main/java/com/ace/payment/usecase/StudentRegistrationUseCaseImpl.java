package com.ace.payment.usecase;

import com.ace.payment.model.Payment;
import com.ace.payment.model.PaymentState;
import com.ace.registration.model.*;
import io.vavr.Tuple2;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
