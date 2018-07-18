package com.frostinteractive.registration.model;

import com.frostinteractive.payment.model.Payment;
import com.frostinteractive.payment.model.PaymentId;
import com.frostinteractive.payment.model.PaymentState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.val;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "student_registrations")
@ApiModel(description = "Student Registration class contains list of registration ans payments")
public class StudentRegistration {

    @EmbeddedId
//    @Embedded
    @ApiModelProperty(notes = "Student Id")
    private StudentId studentId;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "student_id")
    @ApiModelProperty(notes = "List of the student enrolled to courses")
    private List<Registration> registrations = new ArrayList<>();

//    @Setter(AccessLevel.PRIVATE)
//    @Transient
//    @ApiModelProperty(notes = "List of the student paid for courses")
//    private List<Payment> payments = new ArrayList<>();
    @Transient
    private List<PaymentId> paymentIdList = new ArrayList<>();


    public Optional<PaymentId> findById(PaymentId paymentId) {
        return this.paymentIdList.stream().filter(x -> x.getPaymentId().equals(paymentId)).findAny();
    }

    private Optional<Registration> findRegistrationById(RegistrationId registrationId){
        return this.registrations.stream().filter(x->x.getRegistrationId().equals(registrationId)).findAny();
    }

    private List<Registration> findRegistrationByCourseIds(List<CourseId> courseIdList){
        List<Registration> registrationsToBeModified = new ArrayList<>();
        courseIdList.stream().forEach(x->{
            val registration = this.registrations.stream().filter(y->y.getCourseId().equals(x)).findAny();
            if(registration.isPresent())
                registrationsToBeModified.add(registration.get());
        });
        return registrationsToBeModified;
    }

    public StudentRegistration payForRegistration(PaymentVO payment) {
        if (payment.getPaymentState().equals(PaymentState.SUCCESS)) {
            this.paymentIdList.add(payment.getPaymentId());

            val registrationsTobeModified = this.findRegistrationByCourseIds(payment.getCourseIdList());

            registrationsTobeModified.stream().filter(x->x.getRegistrationState().equals(RegistrationState.APPROVED)).
                    forEach(x->x.setRegistrationState(RegistrationState.CONFIRMED));

            return this;
        } else {
            this.paymentIdList.add(payment.getPaymentId());
            return this;
        }

    }

    public boolean canYouRegisterForOneMoreCourse(){
        return this.registrations.size()<5;
    }

    public boolean hasRegisteredForCourse(CourseId courseId){
        return this.registrations.stream().filter(x->x.getCourseId().equals(courseId)).count()==1;
    }

    public void createRegistration(Registration registration){

        this.registrations.add(registration);

    }


}
