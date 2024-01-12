package org.example.control;

//import java.util.*;

import org.example.model.InsuranceVO;

import java.util.*;

public class TestCollections {
    public static void main(String[] arguments){

        testArrayListwithValueObject();

//        testArrayList();
//        testArray();


//        Set<String> value= testGetSetOfValues();
//        Iterator<String> it=value.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

//        Set<String> treeSet= testTreeSet();
//        Iterator<String> it1=treeSet.iterator();
//        while (it1.hasNext()){
//            System.out.println(it1.next());
//        }


//        ArrayList<String> car=testIterator();
//        Iterator<String> it = car.iterator();
//        // Print the first item
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

//        testEvenNumber();
//        testCondition();
//        testGreater();

//        ArrayList<String> city = getCityNames();
//        for (int i=0; i<city.size() ; i++){
//            String name=city.get(i);
//            if (name.length()>=5) {
//                System.out.println(name);
//            }
//        }

//        HashMap<Integer,String> cityNames = getCityNamesWithPinCode();
////        cityNames.forEach((key, value)->processHashMapElement(key,value));
//        processHashMapUsingSet(cityNames);
//        HashMap will allow null

//        Hashtable<Integer,String> city=createCityUsingHashTable();
//        processHashTable(city);

//        List<String> existingItems = new ArrayList<>();
//            existingItems.add("Carrots");
//            existingItems.add("apple");
//            existingItems.add("orange");
//            existingItems.add("milk");
//            existingItems.add("Carrots");
//
//            ArrayList<String> shoppingItems = getShoppingItems();
//            for (int i=0; i<existingItems.size() ;i++){
//                String existingItem = existingItems.get(i);
//                for (int j=0; j<shoppingItems.size();j++){
//                    String shoppingItem = shoppingItems.get(j);
//                    if (existingItem.toUpperCase().contains(shoppingItem.toUpperCase())){
//                        System.out.println(existingItem);
//                    }else {
//                        System.out.println("No match.");
//                    }
//                }
//            }

    }
    private static Set<String> testGetSetOfValues(){
        Set<String> object=new HashSet<>();
        object.add("jeswin");
        object.add("shalwin");
        object.add("ashok");
        object.add("merlin");
        object.add("merlin");
        return object;
    }

    private static Set<String> testTreeSet(){
        Set<String> object=new TreeSet<>();
        object.add("jeswin");
        object.add("shalwin");
        object.add("ashok");
        object.add("merlin");
        object.add("merlin");
        return object;
    }


    private static void testArray() {
        String[] cityNames=new String[10];
        cityNames[0]="chennai";
        cityNames[1]="mdu";
        cityNames[2]="cbe";
//        System.out.println(cityNames.length);
//        System.out.println(cityNames[0]+" "+cityNames[1]+" "+cityNames[2]);
        for (int i=0;i<cityNames.length;i=i+1){
            System.out.println(cityNames[i]);
            System.out.println(i);
        }
    }
    private static void testArrayList(){
        ArrayList<String> cityNames=new ArrayList<>();
        cityNames.add("chennai");
        cityNames.add("cbe");
        cityNames.add("mumbai");
        cityNames.add("delhi");
//        for (int i=0;i<cityNames.size();i++){
//            System.out.println(cityNames.get(i));
//        }
//        for(String cityName:cityNames){
//            System.out.println(cityName);
//        }
        cityNames.stream().forEach(cityName->System.out.println(cityName));
    }
    private static ArrayList<String> testIterator(){
        // Make a collection
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        return cars;
    }
    private static void testEvenNumber(){
        int[] evenNumbers=new int[10];
//        evenNumbers[0]=1;
//        evenNumbers[1]=2;
//        evenNumbers[2]=3;
//        evenNumbers[3]=4;
//        evenNumbers[4]=5;
//        evenNumbers[5]=6;
//        evenNumbers[6]=7;
//        evenNumbers[7]=8;
//        evenNumbers[8]=9;
//        evenNumbers[9]=10;
        for (int j=0;j<10;j++){
            evenNumbers[j]=j+1;
            System.out.println(evenNumbers[j]);
        }

        for (int i = 0; i<evenNumbers.length ; i++){
            if (evenNumbers[i]%2==0) {
                System.out.println(evenNumbers[i]+" , This is i= " + i);
//                System.out.println("this is i= " + i);
            }
        }
    }
    private static void testCondition(){
//        int i=0;
        String performance=null;
//        if (i>5){
//            performance="Good";
//        } else {
//            performance="Bod";
//        }
        for (int i=0;i<11;i++) {
            performance=i>=5?"Good":"Bad";
            System.out.println(performance);
        }
    }
    private static void testGreater(){
        ArrayList<Integer> number=new ArrayList<>();
        for (int i=0;i<=10;i=i+1){
            number.add(i);
        }
        for (int i=0; i< number.size() ;i++){
            int numbers = number.get(i);
            if (numbers>4){
                System.out.println(numbers);
            }
        }
    }
    private static ArrayList<String> getCityNames(){
        ArrayList<String> cityNames=new ArrayList<>();
        cityNames.add("madurai");
        cityNames.add("chennai");
        cityNames.add("cbe");
        cityNames.add("delhi");
        cityNames.add("maa");
        return cityNames;
    }

    private static HashMap<Integer,String> getCityNamesWithPinCode(){
        HashMap<Integer,String> city=new HashMap<>();
        city.put(625000,"1 madurai");
        city.put(625001,"2 mumbai");
        city.put(625002,"3 chennai");
        city.put(null,"4 cbe");
        city.put(625003,null);
        return city;
    }
    private static void processHashMapElement(Integer key ,String value){
        if (value.length()>5){
            System.out.println(value+" greater than 5.");
        }
    }
    private static ArrayList<String> getShoppingItems(){
        ArrayList<String> items=new ArrayList<>();
        items.add("rice");
        items.add("milk");
        items.add("soap");
        items.add("car");
        return items;
    }
    private static void processHashMapUsingSet(HashMap<Integer,String> place){
        Set<Map.Entry<Integer,String>> enterySet =place.entrySet();
        Iterator<Map.Entry<Integer,String>> it=enterySet.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> entry=it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static Hashtable<Integer,String> createCityUsingHashTable(){
        Hashtable<Integer,String> city=new Hashtable<>();
        city.put(625000,"0 madurai");
        city.put(625001,"1 madurai");
        city.put(625002,"2 chennai");
//        city.put(null,"3 cbe");
//        city.put(null,null);
//        city.put(625003,null);
        return city;
    }
    private static void processHashTable(Hashtable<Integer,String> city){
        Set<Map.Entry<Integer,String>> enterySet =city.entrySet();
        Iterator<Map.Entry<Integer,String>> it=enterySet.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> entry=it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
    private static void testArrayListwithValueObject(){
        // Make a collection
        ArrayList<InsuranceVO> insuranceList = new ArrayList<InsuranceVO>();
        InsuranceVO vo1 = getInsuranceVO(100,1234567801,"jes",12340,2024);
        InsuranceVO vo2 = getInsuranceVO(101,1234567802,"jes1",12345,2024);
        InsuranceVO vo3 = getInsuranceVO(102,1234567803,"jes2",12346,2024);
        InsuranceVO vo4 = getInsuranceVO(103,1234567804,"jes3",12347,2024);
        InsuranceVO vo5 = getInsuranceVO(104,1234567805,"jes4",12348,2024);
        insuranceList.add(vo1);
        insuranceList.add(vo2);
        insuranceList.add(vo3);
        insuranceList.add(vo4);
        insuranceList.add(vo5);

        insuranceList.forEach(insuranceVO -> {System.out.println(insuranceVO.getAmount());
        System.out.println(insuranceVO.getName());
        System.out.println(insuranceVO.getPhoneNumber());
        System.out.println(insuranceVO.getPolicyNumber());
        System.out.println(insuranceVO.getYears());
        });
    }

    private static InsuranceVO getInsuranceVO(int Amount, int PhoneNumber, String Name, int PolicyNumber, int Years) {
        InsuranceVO vo1 = new InsuranceVO();
        vo1.setAmount(Amount);
        vo1.setPhoneNumber(PhoneNumber);
        vo1.setName(Name);
        vo1.setPolicyNumberr(PolicyNumber);
        vo1.setYears(Years);
        return vo1;
    }

}













