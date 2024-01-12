package org.example.model;

import javax.inject.Named;

@Named("Truck")
public class Truck implements VehicleInterface {
    private String type;
    private String model;
    private int loadCapacity;

    public int getLoadCapacity() {
        return this.loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
