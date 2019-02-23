package com.arturos.phonebook.service;

import com.arturos.phonebook.entity.Person;
import com.arturos.phonebook.entity.Phone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mockService")
public class PersonServiceMock implements PersonService {

    @Override
    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setLastName("Ivanov");
        person.setFirstName("Ivan");
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("+79174617676"));
        phones.add(new Phone("+74954987676"));
        person.setPhones(phones);

        personList.add(person);

        person = new Person();
        person.setLastName("Petrov");
        person.setFirstName("Peter");
        phones = new ArrayList<>();
        phones.add(new Phone("+79179117676"));
        phones.add(new Phone("+74959087671"));
        person.setPhones(phones);

        personList.add(person);

        return  personList;
    }
}
