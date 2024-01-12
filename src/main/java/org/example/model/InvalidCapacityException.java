package org.example.model;

public class InvalidCapacityException extends Exception {
    String message;
    String solution;
    @Override
    public String getMessage() {
        return "Problem: "+message+"Solution: "+solution;
    }
    public InvalidCapacityException(){
        this("Capacity Is Wrong"," Should have atleast 8 or 16.");
    }
    public InvalidCapacityException(String message){
        super(message);
    }
    public InvalidCapacityException(String message, String solution){
        this.message=message;
        this.solution=solution;
        System.out.println("Problem: "+message+"Solution: "+solution);
    }
}
