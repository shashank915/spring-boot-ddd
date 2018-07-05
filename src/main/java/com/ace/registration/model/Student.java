package com.ace.registration.model;

import lombok.Data;

@Data
public class Student {
    private StudentId studentId;
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
