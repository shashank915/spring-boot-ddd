package com.ace.registration.infrastructure;

import com.ace.registration.model.StudentId;
import com.ace.registration.model.StudentRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRegistrationRepo extends CrudRepository<StudentRegistration,StudentId> {

}
