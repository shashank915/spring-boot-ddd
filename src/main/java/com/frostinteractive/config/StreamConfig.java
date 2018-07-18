package com.frostinteractive.config;

import com.frostinteractive.streams.PaymentStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({PaymentStream.class})
public class StreamConfig {
}
