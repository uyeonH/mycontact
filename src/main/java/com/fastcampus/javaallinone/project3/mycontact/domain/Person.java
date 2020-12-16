package com.fastcampus.javaallinone.project3.mycontact.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String hobby;

    @Getter
    @Setter
    private String bloodType;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private LocalDate birthday;

    @Getter
    @Setter
    private String job;

    @Getter
    @Setter
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name=\'" + name + '\'' +
                ", age=" + age +
                "}";

    }


}
