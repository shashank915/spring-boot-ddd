package com.ace.registration.model;

import com.ace.payment.model.Payment;
import com.ace.payment.model.PaymentId;
import com.ace.payment.model.PaymentState;
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
@Access(AccessType.FIELD)
public class StudentRegistration {

    @EmbeddedId
    private StudentId studentId;

    @OneToMany
    private List<Registration> registrations = new ArrayList<>();

    @Setter(AccessLevel.PRIVATE)
    @Transient
    private List<Payment> payments = new ArrayList<>();

    public Optional<Payment> findById(PaymentId paymentId) {
        return this.payments.stream().filter(x -> x.getPaymentId().equals(paymentId)).findAny();
    }

    private Optional<Registration> findRegistrationById(RegistrationId registrationId){
        return this.registrations.stream().filter(x->x.getRegistrationId().equals(registrationId)).findAny();
    }

    public StudentRegistration payForRegistration(Payment payment, List<RegistrationId> registrationIds) {
        if (payment.getPaymentState().equals(PaymentState.SUCCESS)) {
            this.payments.add(payment);

            val registrationStream=registrationIds.stream().
                    map(x->this.findRegistrationById(x)).filter(x->x.isPresent()).
                    map(x->x.get());

            registrationStream.filter(x->x.getRegistrationState().equals(RegistrationState.APPROVED)).
                    forEach(x->x.setRegistrationState(RegistrationState.CONFIRMED));

            return this;
        } else {
            this.payments.add(payment);
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
