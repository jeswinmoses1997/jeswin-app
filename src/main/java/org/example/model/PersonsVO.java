package org.example.model;

import java.util.Objects;

public class PersonsVO {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsVO personsVO = (PersonsVO) o;
        return personID == personsVO.personID && Objects.equals(lastName, personsVO.lastName) && Objects.equals(firstName, personsVO.firstName) && Objects.equals(address, personsVO.address) && Objects.equals(city, personsVO.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personID, lastName, firstName, address, city);
    }
    @Override
    public String toString(){
        return firstName +" "+ lastName;
    }

    private int personID;
    private String lastName;
    private String firstName;
    private String address;
    private String city;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
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
