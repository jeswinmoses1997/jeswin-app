package org.example.model;

import org.example.model.CarBuilderPattern;
import org.example.model.Person;
import org.example.model.PersonBuilderPattern;
import org.example.model.PersonBuilderPattern.PersonBuilder;
import org.example.model.CarBuilderPattern.CarBuilder;


public class PersonService {
    public Person create(String name, int age){
       Person object= new Person();
       object.setAgeOfThePerson(age);
       object.setName(name);
       return object;
    }

    public Person createUsingParameterized(String name, int age){
        Person object= new Person(name,age);
        return object;
    }

    public PersonBuilderPattern createUsingBuilderPattern(String name, int age){
        PersonBuilderPattern object= PersonBuilder.builder().setName(name).setAge(age).build();
        return object;
    }

    public CarBuilderPattern createUsingBuilder(String brand, int speed){
        CarBuilderPattern object= CarBuilder.builder().setBrand(brand).setSpeed(speed).build();
        return object;
    }
}
