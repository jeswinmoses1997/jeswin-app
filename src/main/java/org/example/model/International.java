package org.example.model;

import java.io.IOException;

public class International implements TourInterface{
    String Name;
    int Days;
    int Cost;

    public void setName(String name) {
        this.Name = name;
    }

    public void setDays(int days) throws InvalidDaysException {
        this.Days = days;
        if (days<3){
            throw new InvalidDaysException();
        }
    }

    public void setCost(int cost) {
        this.Cost = cost;
        if (cost<1000){
            throw new InvalidCostException();
        }
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getDays() {
        return Days;
    }

    @Override
    public int getCost() {
        return Cost;
    }

    @Override
    public void close() throws IOException {
        System.out.println("hi from close in international");
    }
}
