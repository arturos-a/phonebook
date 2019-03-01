package com.arturos.phonebook.service;

import com.arturos.phonebook.entity.Person;
import com.arturos.phonebook.dto.PersonUi;
import com.arturos.phonebook.entity.Phone;
import com.arturos.phonebook.entity.PhoneType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mockService")
public class PersonServiceMock implements PersonService {

    @Override
    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setId(1L);
        person.setLastName("Ivanov");
        person.setFirstName("Ivan");
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(1L,"+79174617676"));
        phones.add(new Phone(2L,"+74954987676"));
        person.setPhones(phones);

        personList.add(person);

        person = new Person();
        person.setId(2L);
        person.setLastName("Petrov");
        person.setFirstName("Peter");
        phones = new ArrayList<>();
        phones.add(new Phone(1L,"+79179117676"));
        phones.add(new Phone(2L,"+74959087671"));
        person.setPhones(phones);

        personList.add(person);

        return  personList;
    }

    @Override
    public Person getPersonById(String s) {
       Person person = new Person();
       person.setId(1L);
        person.setLastName("Petrov");
        person.setFirstName("Peter");
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(PhoneType.HOME,"+79179117676"));
        phones.add(new Phone(PhoneType.MOBILE,"+74959087671"));
        person.setPhones(phones);

        return person;
    }

    @Override
    public void savePerson(Person person) {
        System.out.println(person);

    }
}
