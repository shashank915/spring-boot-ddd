package com.frostinteractive.registration.model.dto;

import com.frostinteractive.registration.model.StudentId;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {

    private StudentId studentId;
    private String studentName;
    private LocalDate localDate;
}
