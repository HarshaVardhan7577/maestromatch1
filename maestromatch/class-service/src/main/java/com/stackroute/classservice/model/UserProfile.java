package com.stackroute.classservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


public class UserProfile {


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    int userId;
    private String mailId;

    private String firstName;

    private String lastName;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    String password;
    String userName;

    public UserProfile() {
    }

    public UserProfile(String mailId, String password, String userName,String firstName,String lastName) {
        this.mailId = mailId;
        this.password = password;
        this.userName = userName;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

