package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@org.hibernate.annotations.NamedNativeQueries(
        @org.hibernate.annotations.NamedNativeQuery(name = "Persons_0selectByLastName",
                query = "SELECT per.PersonID,per.LastName,per.FirstName,per.Address,per.City from Persons per WHERE per.LastName= :name",
                resultClass = Persons.class)
)

@XmlRootElement
@Entity
@Table(name = "Persons", schema= "jeswin")
public class Persons {
    @Id
    @Column(name="PersonID")
    int PersonID;
    @Column(name="LastName")
    String lastName;
    @Column(name="FirstName")
    String firstName;
    @Column(name="Address")
    String address;
    @Column(name="City")
    String city;

    @JsonManagedReference
    @OneToOne(mappedBy = "persons",cascade = CascadeType.ALL)
    private Insurance insurance;

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        this.PersonID = personID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
