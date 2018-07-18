package com.frostinteractive.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentStream {

    String INPUT = "payments-in";
    String OUTPUT = "payments-out";

    @Input(INPUT)
    SubscribableChannel getInputChannel();

    @Output(OUTPUT)
    MessageChannel getOutputChannel();
}
