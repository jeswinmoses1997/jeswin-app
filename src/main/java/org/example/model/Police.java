package org.example.model;

public class Police extends StateGovernmentEmployee implements PersonInterface, GovernmentEmployee {

    @Override
    public String getJob() {
        return "SubInspector";
    }

    @Override
    public int getSalary() {
        return 30000;
    }

    @Override
    public String welcome(){
        return "Hello from Police";
    }
    @Override
    public int getNumberOfYearsOfExperience(){
        return 5;
    }
    @Override
    public  String getTopManagerName(){
        return "CM";
    }
}
