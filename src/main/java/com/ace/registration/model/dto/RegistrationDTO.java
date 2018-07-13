package com.ace.registration.model.dto;

import com.ace.registration.model.CourseId;
import com.ace.registration.model.RegistrationId;
import com.ace.registration.model.RegistrationState;
import com.ace.registration.model.StudentId;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationDTO {
    private RegistrationId registrationId;
    private StudentId studentId;
    private CourseId courseId;
    private RegistrationState registrationState;
//    private LocalDate registrationDate;
}
