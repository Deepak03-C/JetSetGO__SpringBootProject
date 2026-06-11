package com.jetsetgo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "adminId")
    private int adminId;

    @Column(name = "adminName")
    private String adminName;

    @Column(name = "adminEmail", unique = true)
    private String adminEmail;

    @Column(name = "adminPassword")
    private String adminPassword;

    @Column(name = "adminConfirmPassword")
    private String adminConfirmPassword;

    public Admin() {}

    public Admin(int adminId, String adminName, String adminEmail, String adminPassword, String adminConfirmPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminConfirmPassword = adminConfirmPassword;
    }

    public int getAdminId() { return adminId; }
    public void setAdminId(int adminId) { this.adminId = adminId; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }

    public String getAdminEmail() { return adminEmail; }
    public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }

    public String getAdminPassword() { return adminPassword; }
    public void setAdminPassword(String adminPassword) { this.adminPassword = adminPassword; }

    public String getAdminConfirmPassword() { return adminConfirmPassword; }
    public void setAdminConfirmPassword(String adminConfirmPassword) { this.adminConfirmPassword = adminConfirmPassword; }
}
