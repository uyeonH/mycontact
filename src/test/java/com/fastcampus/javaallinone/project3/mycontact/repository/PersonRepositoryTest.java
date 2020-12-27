package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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

        //List<Person> people = personRepository.findAll();

        List<Person> people = personRepository.findByName("yooyeon");
        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("yooyeon");
        assertThat(people.get(0).getAge()).isEqualTo(100);
        assertThat(people.get(0).getBloodType()).isEqualTo("B");

        System.out.println(people);
    }


    @Test
    void findByBloodType() {

        List<Person> result = personRepository.findByBloodType("A");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("yooyeon");
        assertThat(result.get(1).getName()).isEqualTo("david");

    }

    @Test
    void findByBirthdayBetween() {
        List<Person> result = personRepository.findByMonthOfBirthday(5);
        result.forEach(System.out::println);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("yooyeon");
        assertThat(result.get(1).getName()).isEqualTo("david");

    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthday));
        personRepository.save(person);
    }

    private void givenPerson(String name, int age, String bloodType) {
        Person person = new Person(name, age, bloodType);
        personRepository.save(person);
    }
}