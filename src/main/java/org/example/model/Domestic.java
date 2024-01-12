package org.example.model;

import java.io.IOException;

public class Domestic implements TourInterface {
    String name;
    int days;
    int cost;

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(int days) throws InvalidDaysException {
        this.days = days;
        if (days<3){
            throw new InvalidDaysException();
        }
    }

    public void setCost(int cost) {
        this.cost = cost;
        if (cost<1000){
            throw new InvalidCostException();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDays() {
        return days;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public void close() throws IOException {
        System.out.println("hi from domestic close.");
    }
}
