package org.example.model;

public class VegetableService {
    public VegetableInterface createVegetable(String name){
        int calorie=0;
        if(name.equalsIgnoreCase(CALORIE.PUMPKIN.toString())){
            calorie=CALORIE.PUMPKIN.getCalorie();
            Pumpkin vegetable=new Pumpkin();
            vegetable.setName(name);
            vegetable.setCalorie(calorie);
            return vegetable;
        } else if (name.equalsIgnoreCase(CALORIE.CARROT.toString())) {
            calorie=CALORIE.CARROT.getCalorie();
            Carrot vegetable1=new Carrot();
            vegetable1.setName(name);
            vegetable1.setCalorie(calorie);
            return vegetable1;
        }else if(name.equalsIgnoreCase(CALORIE.BEANS.toString())){
            calorie=CALORIE.BEANS.getCalorie();
            Beans vegetable2=new Beans();
            vegetable2.setName(name);
            vegetable2.setCalorie(calorie);
            return vegetable2;
        }
        return null;
    }
}
