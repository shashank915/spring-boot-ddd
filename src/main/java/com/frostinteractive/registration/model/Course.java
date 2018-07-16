package com.frostinteractive.registration.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Course {
    private CourseId courseId;
    private String courseName;
    private int fee;

}
