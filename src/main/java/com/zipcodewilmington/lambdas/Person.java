package com.zipcodewilmington.lambdas;

import java.time.LocalDate;
import java.util.List;

public class Person {
    public enum Sex {
        MALE,
        FEMALE,
        NONE;
    }
    String name;
    int age;
    Sex gender;
    String emailAddress;

    public Person() {
    }
    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
        this.gender = Sex.NONE;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printPerson() {
        System.out.printf("Name: %s\nAge: %d\nSex: %s\nEmail: %s\n%n",
                name, age, gender.toString(), emailAddress);
    }

    // returns number of Person printed
    public static int printPersons(
            List<Person> roster, CheckPerson tester) {
        int count = 0;
        for (Person p : roster) {
            if (tester.test(p)) {
                count++;
                p.printPerson();
            }
        }
        return count;
    }
}
