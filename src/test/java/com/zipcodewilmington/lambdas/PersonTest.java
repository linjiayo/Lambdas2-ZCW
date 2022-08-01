package com.zipcodewilmington.lambdas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    List<Person> personList;

    @BeforeEach
    public void init() {
        personList = new ArrayList<>(16);
        for (int i = 14; i < 25; i++) {
            personList.add(new Person(i));
        }
    }

    @org.junit.jupiter.api.Test
    void testPrintPersonsLocal() {
        EligibleAdultChecker checker = new EligibleAdultChecker();
        Integer expected = 7;

        Integer actual = Person.printPersons(personList, checker);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrintPersonsAnonymous() {
        Integer expected = 7;

        Integer actual = Person.printPersons(personList, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getAge() >= 18;
            }
        });

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrintPersonsLambda() {
        Integer expected = 7;

        Integer actual = Person.printPersons(personList, (Person p) -> p.getAge() >= 18);

        Assertions.assertEquals(expected, actual);
    }
}