package com.hotelManagementSystem.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;

public class Customer {

    private String document;
    private String numberID;
    private String name;
    private String gender;
    private String country;
    private int roomNumber;

    private Date checkInDate;
    private Date checkInTime;

    private int deposit;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getNumberID() {
        return numberID;
    }

    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender =gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate){
        this.checkInDate = checkInDate;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime){
        this.checkInTime = checkInTime;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit){
        this.deposit = deposit;
    }

}
