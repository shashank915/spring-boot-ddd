package com.frostinteractive.payment.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "payments")
public class Payment {

    @Column(name = "payment_state", columnDefinition = "VARCHAR")
    private PaymentState paymentState;

    @EmbeddedId
    private PaymentId paymentId;

    @Column(name = "amount")
    private double amount;
}
