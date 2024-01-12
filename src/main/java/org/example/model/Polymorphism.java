package org.example.model;

public class Polymorphism {

//    			Access_modifier   return_type   function_name(datatype parameter1, datatype parameter2, …){
//				Function body
//				 return <value>;
//			}
    public int add (int number1, int number2){
        int sum = number1+number2;
        return sum;
    }
    public int add(int number1, int number2, int number3){
        int sum= number1+number2+number3;
        return sum;
//        if they call this method 'add' give them sum
    }
}
