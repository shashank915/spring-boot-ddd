package com.frostinteractive.registration.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "All Details of Student required for Course Registration")
public class Student {
    @ApiModelProperty(notes = "Auto generated id of the student.But id should be passed if some updation is required")
    private StudentId studentId;

    @ApiModelProperty(notes = "Name of the student")
    private String studentName;
//    public Student(String name,StudentId sid)
//    {
//        studentId=sid;
//        studentName=name;
//    }

//    public Either<String,Register> register(CourseId cid, List<Register> list)
//    {
//        Register register=new Register(studentId,cid);
//        if(!register.checkCourseSelectionAllow(list))
//            register=null;
//
//        if(register==null)
//            return Either.left("registration fail");
//        else
//            return Either.right(register);
//
//    }
}
