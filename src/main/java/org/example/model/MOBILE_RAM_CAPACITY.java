package org.example.model;

public enum MOBILE_RAM_CAPACITY {
    APPLE(256), SAMSUNG(128);
    private int capacity;
    MOBILE_RAM_CAPACITY(int capacity){
        this.capacity=capacity;
    }
    public int getCapacity(){
        return capacity;
    }
}
