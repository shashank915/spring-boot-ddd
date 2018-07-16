package com.frostinteractive.registration.model.idgenerators;

import com.frostinteractive.payment.model.PaymentId;

public interface PaymentIdGenerator {
    PaymentId nextPaymentId();
}
