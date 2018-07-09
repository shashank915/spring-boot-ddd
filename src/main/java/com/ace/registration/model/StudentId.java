package com.ace.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
public class StudentId implements Serializable {
    private Long studentId;
}
