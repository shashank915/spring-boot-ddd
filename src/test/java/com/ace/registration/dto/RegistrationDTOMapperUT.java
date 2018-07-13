package com.ace.registration.dto;

import com.ace.registration.model.*;
import com.ace.registration.model.dto.RegistrationDTO;
import com.example.demo.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class RegistrationDTOMapperUT {


    //manual mapping
    @Test
    public void registrationMapperTest(){
        ModelMapper regisModelMapper = new ModelMapper();

        //create dto object
        RegistrationDTO registrationDTO = new RegistrationDTO();

        //create entity object
        Registration registration = new Registration();
        registration.setRegistrationId(new RegistrationId(1l));
        registration.setStudentId(new StudentId(1l));
        registration.setCourseId(new CourseId(1l));
        registration.setRegistrationState(RegistrationState.APPROVED);
        registration.setRegistrationDate(LocalDate.now());

        //map entity to the dto
        regisModelMapper.map(registration,registrationDTO);

        assertThat(registrationDTO.getRegistrationId()).isEqualTo(registration.getRegistrationId());
        assertThat(registrationDTO.getStudentId()).isEqualTo(registration.getStudentId());
        assertThat(registrationDTO.getCourseId()).isEqualTo(registration.getCourseId());
        assertThat(registrationDTO.getRegistrationState()).isEqualTo(registration.getRegistrationState());
//        assertThat(registrationDTO.getRegistrationDate()).isEqualTo(registration.getRegistrationDate());
    }
}
