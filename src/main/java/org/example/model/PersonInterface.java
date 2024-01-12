package org.example.model;

public interface PersonInterface {
    String getJob();
    int getSalary();
    default String welcome(){
        return "Hello";
    }
    int getNumberOfYearsOfExperience();
}
