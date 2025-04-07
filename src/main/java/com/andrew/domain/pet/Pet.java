package com.andrew.domain.pet;

import com.andrew.domain.address.Address;

public class Pet {
    private String name;
    private PetType petType;
    private PetSex petSex;
    private Address address;
    private String age;
    private String weight;
    private String race;

    public Pet(String name, PetType petType, PetSex petSex, Address address, String age, String weight, String race) {
        this.name = name;
        this.petType = petType;
        this.petSex = petSex;
        this.address = address;
        this.age = age;
        this.weight = weight;
        this.race = race;
    }

    @Override
    public String toString() {
        return "Pet{" +
               "name='" + name + '\'' +
               ", petType=" + petType +
               ", petSex=" + petSex +
               ", address=" + address +
               ", age=" + age +
               ", weight=" + weight +
               ", race='" + race + '\'' +
               '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetSex getPetSex() {
        return petSex;
    }

    public void setPetSex(PetSex petSex) {
        this.petSex = petSex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
