package com.jetsetgo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "packagesbooked")
public class PackageBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "packagesbookedplace")
    private String packagesbookedplace;

    @Column(name = "packagesbookeddays")
    private String packagesbookeddays;

    @Column(name = "packagesbookedusername")
    private String packagesbookedusername;

    @Column(name = "packagesbookedusercontact")
    private long packagesbookedusercontact;

    @Column(name = "packagesbookeddate")
    private String packagesbookeddate;

    @Column(name = "packagesbookedmemberscount")
    private int packagesbookedmemberscount;

    public PackageBooking() {}

    public PackageBooking(String place, String days, String username, long contact, String date, int members) {
        this.packagesbookedplace = place;
        this.packagesbookeddays = days;
        this.packagesbookedusername = username;
        this.packagesbookedusercontact = contact;
        this.packagesbookeddate = date;
        this.packagesbookedmemberscount = members;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPackagesbookedplace() { return packagesbookedplace; }
    public void setPackagesbookedplace(String packagesbookedplace) { this.packagesbookedplace = packagesbookedplace; }

    public String getPackagesbookeddays() { return packagesbookeddays; }
    public void setPackagesbookeddays(String packagesbookeddays) { this.packagesbookeddays = packagesbookeddays; }

    public String getPackagesbookedusername() { return packagesbookedusername; }
    public void setPackagesbookedusername(String packagesbookedusername) { this.packagesbookedusername = packagesbookedusername; }

    public long getPackagesbookedusercontact() { return packagesbookedusercontact; }
    public void setPackagesbookedusercontact(long packagesbookedusercontact) { this.packagesbookedusercontact = packagesbookedusercontact; }

    public String getPackagesbookeddate() { return packagesbookeddate; }
    public void setPackagesbookeddate(String packagesbookeddate) { this.packagesbookeddate = packagesbookeddate; }

    public int getPackagesbookedmemberscount() { return packagesbookedmemberscount; }
    public void setPackagesbookedmemberscount(int packagesbookedmemberscount) { this.packagesbookedmemberscount = packagesbookedmemberscount; }
}
