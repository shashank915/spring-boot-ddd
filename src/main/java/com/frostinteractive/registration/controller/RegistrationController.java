package com.frostinteractive.registration.controller;

import com.frostinteractive.registration.model.*;
import com.frostinteractive.registration.model.dto.RegistrationDTO;
import com.frostinteractive.registration.model.dto.StudentDTO;
import com.frostinteractive.registration.service.StudentRegistrationService;
import com.frostinteractive.util.DTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value = "Student Registration API",
        description = "API to register Student to course and to get enrolled courses for student.")
public class RegistrationController {

    @Autowired
    StudentRegistrationService service;

    @ApiOperation(value = "Register Student to some Course",
            notes = "Also returns a link to retrieve all Student Registration",
            response = String.class
    )
    @PostMapping("/registration/{courseId}")
    public ResponseEntity<String> registerStudentToCourse(@RequestBody Student student,
                                                        @PathVariable("courseId")Long courseId){
        Course course = new Course();
        course.setCourseId(new CourseId(courseId));

        service.addStudentRegistration(course,student);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/registration")
    @ApiOperation(value = "Register Student to some Course",
            notes = "Also returns a link to retrieve all Student Registration",
            response = StudentRegistration.class)
    public ResponseEntity<StudentRegistration> getCoursesAccStudent(@RequestParam("studentId") Long studentId){
        Optional<StudentRegistration> studentRegistrationByStudentId = service
                .getStudentRegistrationByStudentId(new StudentId(studentId));
        if(studentRegistrationByStudentId.isPresent()){
            return ResponseEntity.ok(studentRegistrationByStudentId.get());
        }
        return ResponseEntity.noContent().build();
    }
}
