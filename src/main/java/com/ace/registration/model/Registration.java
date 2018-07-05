package com.ace.registration.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class Registration {
    private RegistrationId registrationId;
    private StudentId studentId;
    private CourseId courseId;
    private RegistrationState registrationState;
    private LocalDate registrationDate;
//    String status=null;
//    public Register(StudentId sid,CourseId cid)
//    {
//        studentId=sid;
//        courseId=cid;
//    }
//
//    public void checkRegistrationValid(List<Register> list)
//    {
//       // list.stream().filter(reg->reg.courseId.getCourseId()==cid).collect(Collectors.toList()).size();
//        if(list.size()<10)
//            status="approved";
//        else
//            status="waiting";
//    }
//    public boolean checkCourseSelectionAllow(List<Register> list)
//    {
//        if(list.size()<5)
//            return true;
//            else
//                return false;
//    }

}
