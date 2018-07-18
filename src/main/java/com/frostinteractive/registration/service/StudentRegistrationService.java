package com.frostinteractive.registration.service;


import com.frostinteractive.registration.infrastructure.StudentRegistrationRepo;
import com.frostinteractive.registration.model.*;
import com.frostinteractive.registration.usecase.RegistrationUseCase;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentRegistrationService {

    @Autowired
    StudentRegistrationRepo repository;

    @Autowired
    RegistrationUseCase registrationUseCase;

    public void addStudentRegistration(Course course, Student student){
        List<StudentRegistration> studentRegistrationList=new ArrayList<>();
        repository.findAll().forEach(x->studentRegistrationList.add(x));

        val registrationEither=registrationUseCase.
                registerStudent(course,student,studentRegistrationList);
        if (registrationEither.isRight()){
            repository.save(registrationEither.get());
        }
    }

    public Optional<StudentRegistration> getStudentRegistrationByStudentId(StudentId studentId){
        return repository.findById(studentId);
    }

    public boolean makePayment(PaymentVO paymentVO){
        Optional<StudentRegistration> studentRegistrationByStudentId = getStudentRegistrationByStudentId(paymentVO.getStudentId());

        log.info("Student Registration received (y/n): ",studentRegistrationByStudentId.isPresent());
        if(studentRegistrationByStudentId.isPresent()){
            StudentRegistration studentRegistration = registrationUseCase.payForStudentCourses(paymentVO, studentRegistrationByStudentId.get());
            repository.save(studentRegistration);

            return true;
        }
        return false;
    }
}
