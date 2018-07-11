package com.ace.registration.service;


import com.ace.registration.infrastructure.StudentRegistrationRepo;
import com.ace.registration.model.Course;
import com.ace.registration.model.Student;
import com.ace.registration.model.StudentId;
import com.ace.registration.model.StudentRegistration;
import com.ace.registration.usecase.RegistrationUseCase;
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

    public Optional<StudentRegistration> getStudentRegistration(StudentId studentId){
        return repository.findById(studentId);
    }

    public void addStudentRegistration(Course course, Student student){
        List<StudentRegistration> studentRegistrationList=new ArrayList<>();
        repository.findAll().forEach(x->studentRegistrationList.add(x));

        val registrationEither=registrationUseCase.
                registerStudent(course,student,studentRegistrationList);
        if (registrationEither.isRight()){
            repository.save(registrationEither.get());
        }
    }
}
