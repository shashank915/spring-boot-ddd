package com.frostinteractive.registration.controller;

import com.frostinteractive.registration.model.*;
import com.frostinteractive.registration.model.dto.RegistrationDTO;
import com.frostinteractive.registration.model.dto.StudentDTO;
import com.frostinteractive.registration.service.StudentRegistrationService;
import com.frostinteractive.util.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    StudentRegistrationService service;


    @PostMapping("/registration/{courseId}")
    public ResponseEntity<String> registerStudentToCourse(@DTO(StudentDTO.class) Student student,
                                                        @PathVariable("courseId")Long courseId){
        Course course = new Course();
        course.setCourseId(new CourseId(courseId));

        service.addStudentRegistration(course,student);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/registration/{studentId}")
    public ResponseEntity<StudentRegistration> getCoursesAccStudent(@PathVariable("studentId") Long studentId){
        Optional<StudentRegistration> studentRegistrationByStudentId = service
                .getStudentRegistrationByStudentId(new StudentId(studentId));
        if(studentRegistrationByStudentId.isPresent()){
            return ResponseEntity.ok(studentRegistrationByStudentId.get());
        }
        return ResponseEntity.noContent().build();
    }
}
