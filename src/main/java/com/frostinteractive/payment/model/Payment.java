package com.frostinteractive.payment.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "payments")
public class Payment {

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_state")
    private PaymentState paymentState;

    @EmbeddedId
//    @GeneratedValue()
    private PaymentId paymentId;

    @Column(name = "amount")
    private double amount;
}
