package org.example.model;

public class MobileService {
    public MobileInterface createMobile(String brand, String model,int price){
        int capacity=0;
        if (brand.equals(MOBILE_RAM_CAPACITY.APPLE.toString())){
            capacity=MOBILE_RAM_CAPACITY.APPLE.getCapacity();

            Apple mobile=new Apple();
            mobile.setCapacity(capacity);
            mobile.setModel(model);
            mobile.setBrand(brand);
            mobile.setPrice(price);

            return mobile;
        }else{
            capacity=MOBILE_RAM_CAPACITY.SAMSUNG.getCapacity();

            Samsung mobile1=new Samsung();
            mobile1.setCapacity(capacity);
            mobile1.setBrand(brand);
            mobile1.setModel(model);
            mobile1.setPrice(price);

            return mobile1;
        }
    }
}
