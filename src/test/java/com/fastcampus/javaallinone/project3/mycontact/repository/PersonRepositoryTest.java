package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person();
        person.setName("yooyeon");
        person.setAge(100);
        person.setBloodType("A");
        personRepository.save(person);
//        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();
        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("yooyeon");
        assertThat(people.get(0).getAge()).isEqualTo(100);
        assertThat(people.get(0).getBloodType()).isEqualTo("B");

        System.out.println(people);
    }

    @Test
    void hashCodeAndEquals() {
        Person person = new Person();
        Person person2 = new Person();
        System.out.println(person.equals(person2));
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());

        Map<Person, Integer> map = new HashMap<>();

        map.put(person,person.getAge());

        System.out.println(map);
        System.out.println( map.get(person2));

    }

}