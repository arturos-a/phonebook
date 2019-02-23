package com.arturos.phonebook.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String lastName;
    private String firstName;
    private String note;
    @OneToMany
    List<Phone> phones;
}
