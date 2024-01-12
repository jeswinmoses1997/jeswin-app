package org.example.model;

public enum PLACE {
    CITY("Madurai",10),VILLAGE("Cbe",30),METRO("Chennai",25);
    private String place;
    private int quantity;
    PLACE(String place, int quantity) {
        this.place=place;
        this.quantity=quantity;
    }

    public String getPlace() {
        return place;
    }

    public int getQuantity() {
        return quantity;
    }
}
