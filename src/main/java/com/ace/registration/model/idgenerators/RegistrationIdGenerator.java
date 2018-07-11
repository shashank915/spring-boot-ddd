package com.ace.registration.model.idgenerators;

import com.ace.registration.infrastructure.StudentRegistrationRepo;
import com.ace.registration.model.RegistrationId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class RegistrationIdGenerator {

    @Autowired
    StudentRegistrationRepo studentRegistrationRepo;

    public RegistrationId nextRegistrationId(){
        RegistrationId registrationId = studentRegistrationRepo.getMaxRegistrationId();
        return (registrationId != null) ? registrationId : new RegistrationId(1l);
    }
}
