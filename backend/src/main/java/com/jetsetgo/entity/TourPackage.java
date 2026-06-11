package com.jetsetgo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admintourpackages")
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "packageplace")
    private String packageplace;

    @Lob
    @Column(name = "packageimg", columnDefinition = "LONGBLOB")
    private byte[] packageimg;

    @Column(name = "packagedays")
    private String packagedays;

    public TourPackage() {}

    public TourPackage(String packageplace, byte[] packageimg, String packagedays) {
        this.packageplace = packageplace;
        this.packageimg = packageimg;
        this.packagedays = packagedays;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPackageplace() { return packageplace; }
    public void setPackageplace(String packageplace) { this.packageplace = packageplace; }

    public byte[] getPackageimg() { return packageimg; }
    public void setPackageimg(byte[] packageimg) { this.packageimg = packageimg; }

    public String getPackagedays() { return packagedays; }
    public void setPackagedays(String packagedays) { this.packagedays = packagedays; }
}
