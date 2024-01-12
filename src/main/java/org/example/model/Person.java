package org.example.model;

public class Person {
    String name;
    int ageOfThePerson;
    public Person(){}
    public Person(String name1, int ageOfThePerson1){
        this.name=name1;
        this.ageOfThePerson=ageOfThePerson1;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeOfThePerson() {
        return ageOfThePerson;
    }

    public void setAgeOfThePerson(int ageOfThePerson) {
        this.ageOfThePerson = ageOfThePerson;
    }
}
