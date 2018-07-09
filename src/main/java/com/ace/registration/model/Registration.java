package com.ace.registration.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDate;

@Component
@Data
@Entity
@Table(name = "registrations")
@Access(value = AccessType.FIELD)
public class Registration {

    @EmbeddedId
    private RegistrationId registrationId;

    @Column(name = "student_id")
    private StudentId studentId;

    @Embedded
    private CourseId courseId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "registration_state")
    private RegistrationState registrationState;

    @Column(name = "registration_date", columnDefinition = "VARCHAR")
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
