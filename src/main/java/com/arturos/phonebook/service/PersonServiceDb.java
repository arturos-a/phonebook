package com.arturos.phonebook.service;

import com.arturos.phonebook.entity.Person;
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

    public List<Person> init(){
        List<Phone> phoneList = new ArrayList<>();
        Phone phone= new Phone();
        phone.setPhone("+79174548987");
        phoneList.add(phone);
        Person person = new Person();
        person.setPhones(phoneList);
        person.setLastName("Ivanov");
        person.setFirstName("Ivan");
        personRepository.save(person);
        List<Person> all = personRepository.findAll();
        return  all;
    }
    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(String s) {
        return null;
    }

    @Override
    public void savePerson(Person person) {

    }
}
