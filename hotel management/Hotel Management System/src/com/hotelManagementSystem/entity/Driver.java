package com.hotelManagementSystem.entity;

public class Driver {

    private String name;
    private int age;
    private String gender;
    private String carCompany;
    private String carBrand;
    private String available;
    private String location;

    public Driver(){
        name = "";
        age = 0;
        gender = "";
        carCompany = "";
        carBrand = "";
        available = "";
        location = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getCarCompany(){
        return carCompany;
    }

    public void setCarCompany(String carCompany){
        this.carCompany = carCompany;
    }

    public String getCarBrand(){
        return carBrand;
    }

    public void setCarBrand(String carBrand){
        this.carBrand = carBrand;
    }

    public String getAvailable(){
        return available;
    }

    public void setAvailable(String available){
        this.available = available;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

}
