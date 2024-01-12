package org.example.model;

public class CarBuilderPattern {
    private String brand;
    private int speed;

    public CarBuilderPattern(CarBuilder carBuilder){
        this.brand=carBuilder.brand;
        this.speed= carBuilder.speed;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public static class CarBuilder{
        private String brand;
        private int speed;
        private CarBuilder(){

        }

        public static CarBuilder builder(){
            return new CarBuilder();
        }
        public CarBuilder setBrand(String brand){
            this.brand=brand;
            return this;
        }
        public CarBuilder setSpeed(int speed){
            this.speed=speed;
            return this;
        }
        public CarBuilderPattern build() {return new CarBuilderPattern(this);}
    }
}
