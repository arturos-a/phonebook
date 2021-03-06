package com.arturos.phonebook.service;

import com.arturos.phonebook.entity.Person;
import com.arturos.phonebook.dto.PersonUi;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonService {
    public List<Person> getPersonList();
    public Person getPersonById(String s);
    public void  savePerson(Person person);

    void remove(Person person);
}
