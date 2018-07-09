package com.ace.registration.model.idgenerators;

import com.ace.payment.model.PaymentId;

public interface PaymentIdGenerator {
    PaymentId nextPaymentId();
}
