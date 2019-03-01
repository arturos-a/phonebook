package com.arturos.phonebook.dto;

import lombok.Data;

import java.util.List;
@Data
public class PersonUi {
    private Long id;
    private String lastName;
    private String firstName;
    private String note;
    private String mobilePhone;
    private String homePhone;

}
