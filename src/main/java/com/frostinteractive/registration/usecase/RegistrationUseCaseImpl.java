package com.frostinteractive.registration.usecase;

import com.frostinteractive.registration.model.*;

import com.frostinteractive.registration.model.idgenerators.RegistrationIdGenerator;
import io.vavr.control.Either;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RegistrationUseCaseImpl implements RegistrationUseCase {

    @Autowired
    RegistrationIdGenerator registrationIdGenerator;

    private boolean checkCourseRegistrationsLessThan10(Course course,
                                                       List<StudentRegistration> studentRegistrations){
       return studentRegistrations.stream().
               filter(x->x.hasRegisteredForCourse(course.getCourseId())).count()<10;
    }

    private Registration createRegistration(Course course,Student student,RegistrationState registrationState){
        val registration=new Registration();
        registration.setRegistrationId(registrationIdGenerator.nextRegistrationId());
        registration.setCourseId(course.getCourseId());
        registration.setStudentId(student.getStudentId());
        registration.setRegistrationState(registrationState);
        return registration;
    }
    private Registration createApprovedRegistration(Course course,Student student){
        return this.createRegistration(course,student,RegistrationState.APPROVED);

    }
    private Registration createWaitingRegistration(Course course,Student student){
        return this.createRegistration(course,student,RegistrationState.WAITING);

    }

    private StudentRegistration findStudentRegistration(Student student,
                                                        List<StudentRegistration> studentRegistrations){
        val studentRegistration=studentRegistrations.stream().
                filter(x->x.getStudentId().equals(student.getStudentId())).findAny();
        if (studentRegistration.isPresent()){
            return studentRegistration.get();
        }
        else {
            val studentRegistration1=new StudentRegistration();
            studentRegistration1.setStudentId(student.getStudentId());
            return studentRegistration1;
        }
    }

    @Override
    public Either<Exception, StudentRegistration> registerStudent(Course course, Student student,
                                                                  List<StudentRegistration> studentRegistrations) {

        //val studentRegistration=this.findStudentRegistration(student,studentRegistrations);
        //find StudentRegistration for student
        StudentRegistration studentRegistration = getStudentRegistration(studentRegistrations,student.getStudentId());

        if (studentRegistration.canYouRegisterForOneMoreCourse()){

            if (this.checkCourseRegistrationsLessThan10(course,studentRegistrations)){
                val approvedRegistration=this.createApprovedRegistration(course,student);
                studentRegistration.createRegistration(approvedRegistration);
                return Either.right(studentRegistration);
            }
           else {
                val waitingRegistration=this.createWaitingRegistration(course,student);
                studentRegistration.createRegistration(waitingRegistration);
                return Either.right(studentRegistration);
            }
        }
        else {
            return Either.left(new Exception("Student can not register for more than 5 courses"));
        }

    }

    private StudentRegistration getStudentRegistration(List<StudentRegistration> studentRegistrationList,StudentId studentId) {
        Optional<StudentRegistration> optional = studentRegistrationList.stream()
                .filter(x -> x.getStudentId().equals(studentId)).findAny();
        if(optional.isPresent()){
            return optional.get();
        }
        StudentRegistration studentRegistration =  new StudentRegistration();
        studentRegistration.setStudentId(studentId);
        return studentRegistration;
    }

    @Override
    public StudentRegistration payForStudentCourses(PaymentVO paymentVO,
                                                    StudentRegistration studentRegistration) {
        return studentRegistration.payForRegistration(paymentVO);
    }
}
