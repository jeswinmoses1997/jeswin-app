package org.example.control;

import org.example.model.VehicleInterface;

import javax.inject.Inject;
import javax.inject.Named;

public class VehicleService {
    @Inject
    @Named("Bus")
    private VehicleInterface vehicleInterface;
    @Inject
    @Named("Truck")
    private  VehicleInterface vehicleInterface2;
//    public VehicleService(){
//
//    }
    public VehicleInterface createTruck(String type, String model){
//        Truck vehicleInterface = new Truck();
        vehicleInterface.setModel(model);
        vehicleInterface.setType(type);
//        if (model.equals(TRUCK_CAPACITY.MAN.toString())){
//            vehicleInterface.setLoadCapacity(TRUCK_CAPACITY.MAN.getCapacity());
//        }else if (model.equals(TRUCK_CAPACITY.TATA.toString())){
//            vehicleInterface.setLoadCapacity(TRUCK_CAPACITY.TATA.getCapacity());
//        }
        return vehicleInterface;
    }
}
