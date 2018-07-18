package com.frostinteractive.payment.model.dto;

import com.frostinteractive.payment.model.Payment;
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
public class PaymentDTO {
    private StudentId studentId;
    private List<CourseId> courseIdList = new ArrayList<>();
    private PaymentState paymentState;
    private double amount;
}
