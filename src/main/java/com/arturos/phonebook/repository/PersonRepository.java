package com.arturos.phonebook.repository;

import com.arturos.phonebook.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findAll();
    Person save(Person person);
    Person getOne(Long id);
}
