package org.example.model;

public interface MobileInterface {
    String getBrand();
    String getModel();
    int getPrice();
    int getCapacity();
    default String phone() {
        return "samsung or apple";
    }
}
