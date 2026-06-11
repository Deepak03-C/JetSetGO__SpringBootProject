package com.jetsetgo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotelbooked")
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hotelbookedpersonname")
    private String hotelbookedpersonname;

    @Column(name = "hotelbookedpersoncontact")
    private long hotelbookedpersoncontact;

    @Column(name = "hotelbookeddate")
    private String hotelbookeddate;

    @Column(name = "hotelbookedpersoncount")
    private int hotelbookedpersoncount;

    @Column(name = "hotelbookedname")
    private String hotelbookedname;

    @Column(name = "hotelbookedprice")
    private double hotelbookedprice;

    public HotelBooking() {}

    public HotelBooking(String name, long contact, String date, int count, String hotelname, double price) {
        this.hotelbookedpersonname = name;
        this.hotelbookedpersoncontact = contact;
        this.hotelbookeddate = date;
        this.hotelbookedpersoncount = count;
        this.hotelbookedname = hotelname;
        this.hotelbookedprice = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHotelbookedpersonname() { return hotelbookedpersonname; }
    public void setHotelbookedpersonname(String hotelbookedpersonname) { this.hotelbookedpersonname = hotelbookedpersonname; }

    public long getHotelbookedpersoncontact() { return hotelbookedpersoncontact; }
    public void setHotelbookedpersoncontact(long hotelbookedpersoncontact) { this.hotelbookedpersoncontact = hotelbookedpersoncontact; }

    public String getHotelbookeddate() { return hotelbookeddate; }
    public void setHotelbookeddate(String hotelbookeddate) { this.hotelbookeddate = hotelbookeddate; }

    public int getHotelbookedpersoncount() { return hotelbookedpersoncount; }
    public void setHotelbookedpersoncount(int hotelbookedpersoncount) { this.hotelbookedpersoncount = hotelbookedpersoncount; }

    public String getHotelbookedname() { return hotelbookedname; }
    public void setHotelbookedname(String hotelbookedname) { this.hotelbookedname = hotelbookedname; }

    public double getHotelbookedprice() { return hotelbookedprice; }
    public void setHotelbookedprice(double hotelbookedprice) { this.hotelbookedprice = hotelbookedprice; }
}
