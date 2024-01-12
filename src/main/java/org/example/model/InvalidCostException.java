package org.example.model;

public class InvalidCostException extends RuntimeException{
    String message;
    String solution;
    @Override
    public String getMessage() {
        return "Problem: "+message+"Solution: "+solution;
    }
    public InvalidCostException(){
        this("Entered Amount or Cost Is Wrong. ","Should be minimum Rs. 1000/-.");
    }
    public InvalidCostException(String message){
        super(message);
    }
    public InvalidCostException(String message, String solution){
        this.message=message;
        this.solution=solution;
        System.out.println("Problem: "+message+"Solution: "+solution);
    }
}
