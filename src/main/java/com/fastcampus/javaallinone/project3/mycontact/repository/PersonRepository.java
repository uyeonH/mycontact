package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByName(String name);

    List<Person> findByBlockIsNull(); // 차단 되지 않은 경우

    List<Person> findByBlockIsNotNull(); // 차단된 경우

    List<Person> findByBloodType(String bloodType);

    @Query(value = "select person from Person person where person.birthday.monthOfBirthday=?1 and person.birthday.dayOfBirthday=?2")
    List<Person> findByMonthOfBirthday(int monthOfBirthday,int dayOfBirthday);
}
