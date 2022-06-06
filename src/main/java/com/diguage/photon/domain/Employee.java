package com.diguage.photon.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Employee implements Serializable {
    private Long empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private String gender;
}
