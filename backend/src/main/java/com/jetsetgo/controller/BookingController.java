package com.jetsetgo.controller;

import com.jetsetgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private UserService userService;

    @PostMapping("/package")
    public ResponseEntity<Map<String, String>> bookPackage(@RequestBody Map<String, Object> body) {
        Map<String, String> response = new HashMap<>();
        try {
            String place = body.get("place").toString();
            String days = body.get("days").toString();
            String name = body.get("name").toString();
            long contact = Long.parseLong(body.get("contactnumber").toString());
            String date = body.get("journeydate").toString();
            int members = Integer.parseInt(body.get("numberofpersons").toString());

            userService.bookPackage(place, days, name, contact, date, members);
            response.put("status", "success");
            response.put("message", "Tour package booked successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Booking failed: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/hotel")
    public ResponseEntity<Map<String, String>> bookHotel(@RequestBody Map<String, Object> body) {
        Map<String, String> response = new HashMap<>();
        try {
            String name = body.get("name").toString();
            long contact = Long.parseLong(body.get("contactnumber").toString());
            String date = body.get("bookingdate").toString();
            int count = Integer.parseInt(body.get("numberofpersons").toString());
            String hotelname = body.get("hotel").toString();
            double price = Double.parseDouble(body.get("price").toString());

            userService.bookHotel(name, contact, date, count, hotelname, price);
            response.put("status", "success");
            response.put("message", "Hotel booked successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Booking failed: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
