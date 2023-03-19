package com.hotelManagementSystem.entity;

public class Account {
    private String idAccount;
    private String password;
    private String confirmPassword;
    private String keyAnswer;

    public Account() {
        idAccount = "";
        password = "";
        keyAnswer = "";
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getKeyAnswer() {
        return keyAnswer;
    }

    public void setKeyAnswer(String keyAnswer) {
        this.keyAnswer = keyAnswer;
    }

}
