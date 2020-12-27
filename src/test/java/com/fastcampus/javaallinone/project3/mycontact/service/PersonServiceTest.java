package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {


        List<Person> result = personService.getPeopleExcludeBlocks();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("david");
        assertThat(result.get(1).getName()).isEqualTo("benny");

    }
    @Test
    void getPeopleBloodType() {

        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleBloodType();

        result.forEach(System.out::println); // List의 객체가 보기좋게 한 줄씩 노출된다.
    }


    @Test
    void cascadeTest() {

        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        // person.getBlock().setStartDate(LocalDate.now());
        // person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

        // personRepository.delete(person);
        //   personRepository.findAll().forEach(System.out::println);
        //  blockRepository.findAll().forEach(System.out::println);

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson() {
        Person person = personService.getPerson(1L);
        assertThat(person.getName()).isEqualTo("dennis");

    }

    private void givenPeople() {
        givenPerson("yooyeon", 10, "A");
        givenPerson("martin", 11, "B");
        givenPerson("amy", 8, "AB");
        givenBlockPerson("martin", 10, "O");
    }

    private void givenBlocks() {

        givenBlock("martin");
    }


    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private Block givenBlock(String name) {

        return blockRepository.save(new Block(name));
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);
    }


}