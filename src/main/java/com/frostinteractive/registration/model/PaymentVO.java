package com.frostinteractive.registration.model;

import com.frostinteractive.events.PaymentCreationEvent;
import com.frostinteractive.payment.model.PaymentId;
import com.frostinteractive.payment.model.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVO {
    private PaymentId paymentId;
    private StudentId studentId;
    private List<CourseId> courseIdList = new ArrayList<>();
    private PaymentState paymentState;

    public PaymentVO(PaymentCreationEvent event){
        this.paymentId = event.getPaymentId();
        this.studentId = event.getStudentId();
        this.paymentState = event.getPaymentState();
        this.courseIdList = event.getCourseIdList();
    }
}
