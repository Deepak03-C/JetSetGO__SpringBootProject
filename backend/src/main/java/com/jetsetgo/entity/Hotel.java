package com.jetsetgo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adminhotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "hotelimage", columnDefinition = "LONGBLOB")
    private byte[] hotelimage;

    @Column(name = "hotelname")
    private String hotelname;

    @Column(name = "hotelprice")
    private String hotelprice;

    public Hotel() {}

    public Hotel(byte[] hotelimage, String hotelname, String hotelprice) {
        this.hotelimage = hotelimage;
        this.hotelname = hotelname;
        this.hotelprice = hotelprice;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public byte[] getHotelimage() { return hotelimage; }
    public void setHotelimage(byte[] hotelimage) { this.hotelimage = hotelimage; }

    public String getHotelname() { return hotelname; }
    public void setHotelname(String hotelname) { this.hotelname = hotelname; }

    public String getHotelprice() { return hotelprice; }
    public void setHotelprice(String hotelprice) { this.hotelprice = hotelprice; }
}
