package org.example.model;

public class Mobile implements MobileInterface {
    private String brand;

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String model;
    private int price;

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    public void setPrice(int price) {
        this.price = price;
    }
//    @Override
//    public String getModel() {
//        return "IPhone 15 Pro Max";
//    }
//
//    @Override
//    public int getPrice() {
//        return 150000;
//    }
}
