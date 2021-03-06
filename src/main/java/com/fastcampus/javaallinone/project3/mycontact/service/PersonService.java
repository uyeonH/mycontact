package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public List<Person> getPeopleExcludeBlocks() {

        List<Person> people = personRepository.findAll();

        // return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
        //return personRepository.findByBlockIsNotNull(); // 차단 된 사람
        return personRepository.findByBlockIsNull(); // 차단 안 된 사람


    }

    public List<Person> getPeopleBloodType() {

        List<Person> people = personRepository.findAll();

        return personRepository.findByBloodType("A");


    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        //   Person person = personRepository.findById(id).get();
        //System.out.println("Person: "+person);

        Person person = personRepository.findById(id).orElse(null);
        log.info("person: {}", person);
        return person;
    }


    @Transactional
    public void put(Person person){
        personRepository.save(person);
    }
}
