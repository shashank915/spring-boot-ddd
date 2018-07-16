package com.frostinteractive.registration.model.dto;

import com.frostinteractive.registration.model.StudentId;
import lombok.Data;

@Data
public class StudentDTO {

    private StudentId studentId;
    private String studentName;
}
