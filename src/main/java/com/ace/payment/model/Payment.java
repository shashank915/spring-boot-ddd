package com.ace.payment.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Payment {

    private PaymentState paymentState;
    private PaymentId paymentId;
    private double amount;

}
