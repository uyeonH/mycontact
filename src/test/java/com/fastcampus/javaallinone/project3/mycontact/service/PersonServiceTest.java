package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

        result.forEach(System.out::println); // List의 객체가 보기좋게 한 줄씩 노출된다.
    }

    private void givenPeople() {
        givenPerson("yooyeon", 10, "A");
        givenPerson("martin", 11, "B");
        givenPerson("david", 9, "A");
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