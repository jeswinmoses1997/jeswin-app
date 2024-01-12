package org.example.model;

public class InsuranceVO {
    private int PolicyNumber;
    private String Name;
    private int Years;
    private int Amount;
    private int PhoneNumber;

    public int getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumberr(int policyNumber) {
        PolicyNumber = policyNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYears() {
        return Years;
    }

    public void setYears(int years) {
        Years = years;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
