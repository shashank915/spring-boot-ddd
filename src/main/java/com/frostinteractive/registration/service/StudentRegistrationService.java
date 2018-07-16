package com.frostinteractive.registration.service;


import com.frostinteractive.registration.infrastructure.StudentRegistrationRepo;
import com.frostinteractive.registration.model.*;
import com.frostinteractive.registration.usecase.RegistrationUseCase;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
}
