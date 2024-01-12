package org.example.model;

public class InvalidPolicyNumberException extends Exception{
    String message;
    String solution;
    @Override
    public String getMessage() {
        return "Problem: "+message+"Solution: "+solution;
    }
    public InvalidPolicyNumberException(){
        this("policy Number Is Wrong","should have minium 5 didgits.");
    }
    public InvalidPolicyNumberException(String message){
        super(message);
    }
    public InvalidPolicyNumberException(String message, String solution){
        this.message=message;
        this.solution=solution;
        System.out.println("Problem: "+message+"Solution: "+solution);
    }
}
