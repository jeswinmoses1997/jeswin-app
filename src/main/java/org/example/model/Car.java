package org.example.model;

public class Car {
    public Car (String brand, int speed, int kmpl){
        this.brand=brand;
        this.kmpl=kmpl;
        this.speed=speed;
    }
    String brand;
    int speed;
    int kmpl;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getKmpl() {
        return kmpl;
    }

    public void setKmpl(int kmpl) {
        this.kmpl = kmpl;
    }
}
