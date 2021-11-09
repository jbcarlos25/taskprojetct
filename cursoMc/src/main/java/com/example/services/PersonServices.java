package com.example.services;

import com.example.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Carlos");
        person.setLastName("Benvenuto");
        person.setAddress("rua ali e aqui");
        person.setGender("Masculino");
        return person;
    }

    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            personList.add(personMock(i));
        }
        return personList;
    }

    public Person create(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }

    public void delete(String id) {

    }

    private Person personMock(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Carlos" + i);
        person.setLastName("Benvenuto" + i);
        person.setAddress("rua ali e aqui" + i);
        person.setGender("Masculino" + i);
        return person;
    }
}
