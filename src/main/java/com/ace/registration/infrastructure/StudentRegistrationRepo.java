package com.ace.registration.infrastructure;

import com.ace.registration.model.StudentId;
import com.ace.registration.model.StudentRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface StudentRegistrationRepo extends CrudRepository<StudentRegistration,StudentId> {


}
