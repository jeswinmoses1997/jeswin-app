package org.example.model;

public class PlaceService {
    public PlaceInterface createPlace(String place){
        int quantity=0;
        if (place.equalsIgnoreCase(PLACE.CITY.toString())){
            quantity=PLACE.CITY.getQuantity();
            City object1=new City();
            object1.setName(place);
            object1.setQuantity(quantity);
            return object1;
        }else if (place.equalsIgnoreCase(PLACE.METRO.toString())){
            quantity=PLACE.METRO.getQuantity();
            Metro object2=new Metro();
            object2.setName(place);
            object2.setQuantity(quantity);
            return object2;
        }
        else if (place.equalsIgnoreCase(PLACE.VILLAGE.toString())){
            quantity=PLACE.VILLAGE.getQuantity();
            Village object3=new Village();
            object3.setName(place);
            object3.setQuantity(quantity);
            return object3;
        }
        return null;
    }
}



