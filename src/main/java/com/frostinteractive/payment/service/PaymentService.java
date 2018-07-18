package com.frostinteractive.payment.service;

import com.frostinteractive.events.PaymentCreationEvent;
import com.frostinteractive.payment.infrastructure.PaymentRepository;
import com.frostinteractive.payment.model.Payment;
import com.frostinteractive.payment.model.PaymentId;
import com.frostinteractive.registration.model.CourseId;
import com.frostinteractive.registration.model.StudentId;
import com.frostinteractive.streams.PaymentStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.List;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentStream paymentStream;


    public void makePayment(StudentId studentId, List<CourseId > courseIdList, Payment payment){
        payment.setPaymentId(new PaymentId(1l));
        Payment payment1 = paymentRepository.save(payment);

        //if save operation is successful then raise an PaymentCreationEvent
        if(payment1 != null){
            MessageChannel messageChannel = paymentStream.getOutputChannel();

            PaymentCreationEvent paymentCreationEvent = new PaymentCreationEvent();
            paymentCreationEvent.setPaymentId(payment1.getPaymentId());
            paymentCreationEvent.setStudentId(studentId);
            paymentCreationEvent.setCourseIdList(courseIdList);
            paymentCreationEvent.setPaymentState(payment1.getPaymentState());

            messageChannel.send(MessageBuilder.withPayload(paymentCreationEvent)
            .setHeader(MessageHeaders.CONTENT_TYPE,MimeTypeUtils.APPLICATION_JSON)
            .build());

            log.info("","Event Raised Succefully");

        }

    }
}
