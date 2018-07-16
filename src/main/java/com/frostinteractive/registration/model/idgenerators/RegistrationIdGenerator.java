package com.frostinteractive.registration.model.idgenerators;

import com.frostinteractive.registration.infrastructure.StudentRegistrationRepo;
import com.frostinteractive.registration.model.RegistrationId;
import org.springframework.beans.factory.annotation.Autowired;
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
