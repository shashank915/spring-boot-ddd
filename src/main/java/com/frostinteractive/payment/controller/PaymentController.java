package com.frostinteractive.payment.controller;

import com.frostinteractive.payment.model.Payment;
import com.frostinteractive.payment.model.dto.PaymentDTO;
import com.frostinteractive.payment.service.PaymentService;
import org.apache.kafka.common.protocol.types.Field;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService service;



    @PostMapping("/payments")
    public ResponseEntity<String> makePayment(@RequestBody PaymentDTO paymentDTO){
        Payment payment = new Payment();
        payment.setPaymentState(paymentDTO.getPaymentState());
        payment.setAmount(paymentDTO.getAmount());
        service.makePayment(paymentDTO.getStudentId(),paymentDTO.getCourseIdList(),payment);
        return ResponseEntity.ok("Success");
    }

}
