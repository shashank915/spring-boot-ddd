package com.frostinteractive.payment.infrastructure;

import com.frostinteractive.payment.model.Payment;
import com.frostinteractive.payment.model.PaymentId;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PaymentRepository extends CrudRepository<Payment,PaymentId> {
}
