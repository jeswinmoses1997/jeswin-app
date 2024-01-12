package org.example.model;

public class InvalidClaimException extends RuntimeException{
    String message;
    String solution;
    @Override
    public String getMessage() {
        return "Problem: "+message+"Solution: "+solution;
    }
    public InvalidClaimException(){
        this("Claim Is Wrong"," Should have atleast 100+.");
    }
    public InvalidClaimException(String message){
        super(message);
    }
    public InvalidClaimException(String message, String solution){
        this.message=message;
        this.solution=solution;
        System.out.println("Problem: "+message+"Solution: "+solution);
    }
}
