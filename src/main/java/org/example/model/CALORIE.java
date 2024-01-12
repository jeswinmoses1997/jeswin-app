package org.example.model;

public enum CALORIE {
    BEANS(30), CARROT(20), PUMPKIN(10);
    private int calorie;
    CALORIE(int calorie){
        this.calorie=calorie;
    }
    public int getCalorie(){
        return calorie;
    }
}
