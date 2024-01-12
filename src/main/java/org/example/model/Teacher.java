package org.example.model;

public class Teacher extends StateGovernmentEmployee implements PersonInterface, GovernmentEmployee {

    @Override
    public String getJob() {
        return "Teacher";
    }

    @Override
    public int getSalary() {
        return 35000;
    }

    public String getSubject(){
        return "English";
    }

    @Override
    public int getNumberOfYearsOfExperience(){
        return 3;
    }
    @Override
    public String getTopManagerName(){
        return "Anbil Mahesh Poyyamozhi";
    }
}
