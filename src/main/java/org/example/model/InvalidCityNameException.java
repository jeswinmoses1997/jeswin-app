package org.example.model;

public class InvalidCityNameException extends Exception{
    String message;
    String solution;
    @Override
    public String getMessage() {
        return "Problem: "+message+"Solution: "+solution;
    }
    public InvalidCityNameException(){
        this("City Is Wrong. ","Should have minimum 5 letters.");
    }
    public InvalidCityNameException(String message){
        super(message);
    }
    public InvalidCityNameException(String message, String solution){
        this.message=message;
        this.solution=solution;
        System.out.println("Problem: "+message+"Solution: "+solution);
    }
}
