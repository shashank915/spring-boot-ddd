package com.ace.registration.model;

import lombok.Data;

@Data
public class Course {
    private CourseId courseId;
    private String courseName;
    private int fee;

}
