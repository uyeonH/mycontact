package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
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

        map.put(person, person.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));

    }

    @Test
    void findByBloodType() {

        givenPerson("yooyeon", 60, "A");
        givenPerson("amy", 50, "AB");
        givenPerson("jane", 40, "B");
        givenPerson("lily", 30, "O");
        givenPerson("david", 20, "A");

        List<Person> result = personRepository.findByBloodType("A");
        result.forEach(System.out::println);

    }

    @Test
    void findByBirthdayBetween() {
        givenPerson("yooyeon", 60, "A", LocalDate.of(1996, 5, 8));
        givenPerson("amy", 50, "AB", LocalDate.of(2010, 5, 2));
        givenPerson("jane", 40, "B", LocalDate.of(2020, 5, 9));
        givenPerson("lily", 30, "O", LocalDate.of(2030, 5, 10));
        givenPerson("david", 20, "A", LocalDate.of(2040, 5, 11));

        List<Person> result = personRepository.findByMonthOfBirthday(5);
        result.forEach(System.out::println);


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