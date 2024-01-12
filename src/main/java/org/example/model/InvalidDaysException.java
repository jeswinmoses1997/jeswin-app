package org.example.model;

public class InvalidDaysException extends Exception{
    String message;
    String solution;
    @Override
    public String getMessage() {
        return "Problem: "+message+"Solution: "+solution;
    }
    public InvalidDaysException(){
        this("Entered Days Is Wrong. ","Should have minimum 3 days.");
    }
    public InvalidDaysException(String message){
        super(message);
    }
    public InvalidDaysException(String message, String solution){
        this.message=message;
        this.solution=solution;
        System.out.println("Problem: "+message+"Solution: "+solution);
    }
}
