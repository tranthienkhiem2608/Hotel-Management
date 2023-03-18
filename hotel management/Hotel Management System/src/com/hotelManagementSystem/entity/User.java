package com.hotelManagementSystem.entity;

public class User {
    private String id;
    private String name;
    private String gender, position;
    private String email;
    private String phone;
    private String salary;
    private int age;

    public User() {
        id = "";
        name = "";
        age = 0;
        gender = "";
        email = "";
        phone = "";
        position = "";
        salary = "";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public  void setGender(String gender){
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }



}
