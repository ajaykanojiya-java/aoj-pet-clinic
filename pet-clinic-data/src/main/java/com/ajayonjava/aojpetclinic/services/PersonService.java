package com.ajayonjava.aojpetclinic.services;

import com.ajayonjava.aojpetclinic.model.Person;

import java.util.Set;

public interface PersonService {
    Person findById(Long id);
    Person save(Person person);
    Set<Person> findAll();
}
