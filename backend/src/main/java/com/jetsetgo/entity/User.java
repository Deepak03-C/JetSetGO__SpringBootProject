package com.jetsetgo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "userName")
    private String userName;

    @Id
    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "userConfirmPassword")
    private String userConfirmPassword;

    public User() {}

    public User(String userName, String userEmail, String userPassword, String userConfirmPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userConfirmPassword = userConfirmPassword;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public String getUserConfirmPassword() { return userConfirmPassword; }
    public void setUserConfirmPassword(String userConfirmPassword) { this.userConfirmPassword = userConfirmPassword; }
}
