package com.frostinteractive.registration.controller;

import com.frostinteractive.registration.model.*;
import com.frostinteractive.registration.model.dto.RegistrationDTO;
import com.frostinteractive.registration.model.dto.StudentDTO;
import com.frostinteractive.registration.service.StudentRegistrationService;
import com.frostinteractive.util.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    StudentRegistrationService service;


    @PostMapping("/registration/register/{courseId}")
    public ResponseEntity<String> registerStudentToCourse(@DTO(StudentDTO.class) Student student,
                                                        @PathVariable("courseId")Long courseId){
        Course course = new Course();
        course.setCourseId(new CourseId(courseId));

        service.addStudentRegistration(course,student);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/registration/getStudentCourse/{studentId}")
    public ResponseEntity<Registration> getCoursesAccStudent(@PathVariable("studentId") Long studentId){
        System.out.println("Hello");
        return ResponseEntity.ok(new Registration());
    }

}
