package org.example.model;

public class InvalidAmountException extends Exception{
    String message;
    String solution;
    @Override
    public String getMessage() {
        return "Problem: "+message+"Solution: "+solution;
    }
    public InvalidAmountException(){
        this("Policy Amount Is Wrong"," Should have minimum Rs. 100/-");
    }
    public InvalidAmountException(String message){
        super(message);
    }
    public InvalidAmountException(String message, String solution){
        this.message=message;
        this.solution=solution;
        System.out.println("Problem: "+message+"Solution: "+solution);
    }
}
