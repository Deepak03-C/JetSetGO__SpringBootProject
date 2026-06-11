package com.jetsetgo.controller;

import com.jetsetgo.entity.TourPackage;
import com.jetsetgo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PackageController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/packages")
    public ResponseEntity<List<Map<String, Object>>> getPackages() {
        List<TourPackage> packages = adminService.getAllPackages();
        List<Map<String, Object>> result = new ArrayList<>();
        for (TourPackage pkg : packages) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", pkg.getId());
            map.put("place", pkg.getPackageplace());
            map.put("days", pkg.getPackagedays());
            if (pkg.getPackageimg() != null) {
                map.put("image", Base64.getEncoder().encodeToString(pkg.getPackageimg()));
            } else {
                map.put("image", "");
            }
            result.add(map);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/admin/packages")
    public ResponseEntity<Map<String, String>> addPackage(
            @RequestParam("img") MultipartFile img,
            @RequestParam("tourplace") String tourplace,
            @RequestParam("days") String days) {
        Map<String, String> response = new HashMap<>();
        try {
            byte[] imageBytes = img.getBytes();
            adminService.addTourPackage(imageBytes, tourplace, days);
            response.put("status", "success");
            response.put("message", "Tour package added successfully");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", "Failed to process image");
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
