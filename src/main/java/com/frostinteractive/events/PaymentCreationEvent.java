package com.frostinteractive.events;

import com.frostinteractive.payment.model.PaymentId;
import com.frostinteractive.payment.model.PaymentState;
import com.frostinteractive.registration.model.CourseId;
import com.frostinteractive.registration.model.StudentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreationEvent {
    private PaymentId paymentId;
    private StudentId studentId;
    private List<CourseId> courseIdList = new ArrayList<>();
    private PaymentState paymentState;
}
