package com.frostinteractive.registration.model.dto;

import com.frostinteractive.registration.model.StudentId;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;

@Data
@ApiModel(description = "All Details of Student required for Course Registration")
public class StudentDTO {

    private StudentId studentId;
    private String studentName;
    private LocalDate localDate;
}
