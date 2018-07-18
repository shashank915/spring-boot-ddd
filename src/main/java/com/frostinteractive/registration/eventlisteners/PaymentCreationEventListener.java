package com.frostinteractive.registration.eventlisteners;

import com.frostinteractive.events.PaymentCreationEvent;
import com.frostinteractive.registration.model.PaymentVO;
import com.frostinteractive.registration.service.StudentRegistrationService;
import com.frostinteractive.streams.PaymentStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentCreationEventListener {

    @Autowired
    StudentRegistrationService service;

    @StreamListener(PaymentStream.INPUT)
    public void handleEvent(@Payload PaymentCreationEvent event){
        PaymentVO vo = new PaymentVO(event);
        service.makePayment(vo);
    }
}
