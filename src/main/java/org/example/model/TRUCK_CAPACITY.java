package org.example.model;

public enum TRUCK_CAPACITY {
    MAN(100), TATA(50);
    private int capacity;
    TRUCK_CAPACITY(int capacity) {
        this.capacity=capacity;
    }
    public int getCapacity() {
        return capacity;
    }
}
