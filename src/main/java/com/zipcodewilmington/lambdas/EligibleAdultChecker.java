package com.zipcodewilmington.lambdas;

public class EligibleAdultChecker implements CheckPerson{

    public EligibleAdultChecker() {}
    @Override
    public boolean test(Person p) {
        return p.getAge() >= 18;
    }
}
