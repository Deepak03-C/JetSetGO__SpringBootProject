package com.jetsetgo.controller;

import com.jetsetgo.entity.Hotel;
import com.jetsetgo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/hotels")
    public ResponseEntity<List<Map<String, Object>>> getHotels() {
        List<Hotel> hotels = adminService.getAllHotels();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", hotel.getId());
            map.put("hotelName", hotel.getHotelname());
            map.put("hotelPrice", hotel.getHotelprice());
            if (hotel.getHotelimage() != null) {
                map.put("image", Base64.getEncoder().encodeToString(hotel.getHotelimage()));
            } else {
                map.put("image", "");
            }
            result.add(map);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/admin/hotels")
    public ResponseEntity<Map<String, String>> addHotel(
            @RequestParam("img") MultipartFile img,
            @RequestParam("hotelname") String hotelname,
            @RequestParam("price") String price) {
        Map<String, String> response = new HashMap<>();
        try {
            byte[] imageBytes = img.getBytes();
            adminService.addHotel(imageBytes, hotelname, price);
            response.put("status", "success");
            response.put("message", "Hotel added successfully");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", "Failed to process image");
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
