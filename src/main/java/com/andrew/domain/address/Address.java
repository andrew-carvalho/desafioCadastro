package com.andrew.domain.address;

public class Address {
    private String houseNumber;
    private String city;
    private String street;

    public Address(String houseNumber, String city, String street) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.getStreet(), this.getHouseNumber(), this.getCity());
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
