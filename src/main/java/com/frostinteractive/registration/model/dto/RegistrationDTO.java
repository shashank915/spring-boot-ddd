package com.frostinteractive.registration.model.dto;

import com.frostinteractive.registration.model.CourseId;
import com.frostinteractive.registration.model.RegistrationId;
import com.frostinteractive.registration.model.RegistrationState;
import com.frostinteractive.registration.model.StudentId;
import lombok.Data;

@Data
public class RegistrationDTO {
    private RegistrationId registrationId;
    private StudentId studentId;
    private CourseId courseId;
    private RegistrationState registrationState;
//    private LocalDate registrationDate;
}
