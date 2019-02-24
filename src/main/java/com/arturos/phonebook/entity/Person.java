package com.arturos.phonebook.entity;

import com.arturos.phonebook.dto.PersonUi;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
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

    public static Person createPerson(PersonUi personUi) {
        Person person = new Person();
        person.setFirstName(personUi.getFirstName());
        person.setLastName(personUi.getLastName());
        person.setNote(personUi.getNote());

        List<Phone> phones = new ArrayList<>();
        Phone temp = new Phone();
        temp.setPhone(personUi.getHomePhone());
        temp.setType(PhoneType.HOME);
        phones.add(temp);

        temp = new Phone();
        temp.setType(PhoneType.MOBILE);
        temp.setPhone(personUi.getMobilePhone());

        person.setPhones(phones);
        return person;
    }
}
