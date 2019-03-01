package com.arturos.phonebook.service;

import com.arturos.phonebook.entity.Person;
import com.arturos.phonebook.dto.PersonUi;
import com.arturos.phonebook.entity.Phone;
import com.arturos.phonebook.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("prodService")
public class PersonServiceDb implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceDb(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(String s) {
        return personRepository.getOne(Long.valueOf(s));
    }

    @Override
    public void savePerson(Person person) {
        System.out.println("zzz="+person);
        personRepository.save(person);

    }
}
