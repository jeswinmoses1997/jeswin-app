package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "insurance", schema = "jeswin")
public class Insurance {
    @Id
    @Column(name = "PolicyNumber")
    int PolicyNumber;
    @Column(name = "Name")
    String Name;
    @Column(name = "Years")
    int Years;
    @Column(name = "Amount")
    int Amount;
    @Column(name = "PhoneNumber")
    int PhoneNumber;
    @Column(name = "PersonID")
    int PersonID;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID",insertable = false, updatable = false)
    private Persons persons;

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        this.PersonID = personID;
    }

    public int getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
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
