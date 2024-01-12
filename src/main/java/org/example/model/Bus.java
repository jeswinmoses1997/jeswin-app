package org.example.model;

import javax.inject.Named;

@Named("Bus")
public class Bus implements VehicleInterface {
    private String type;
    private String model;

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
