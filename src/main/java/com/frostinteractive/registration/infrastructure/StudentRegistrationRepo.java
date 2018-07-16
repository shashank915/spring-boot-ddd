package com.frostinteractive.registration.infrastructure;

import com.frostinteractive.registration.model.RegistrationId;
import com.frostinteractive.registration.model.StudentId;
import com.frostinteractive.registration.model.StudentRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRegistrationRepo extends CrudRepository<StudentRegistration,StudentId> {

    @Query("Select max(r.registrationId) from Registration r")
    RegistrationId getMaxRegistrationId();
}
