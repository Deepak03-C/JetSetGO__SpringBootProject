package com.jetsetgo.controller;

import com.jetsetgo.entity.Admin;
import com.jetsetgo.entity.User;
import com.jetsetgo.service.AdminService;
import com.jetsetgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, String> body) {
        User user = new User(
            body.get("userName"),
            body.get("userEmail"),
            body.get("userPassword"),
            body.get("userConfirmPassword")
        );
        String result = userService.registerUser(user);
        Map<String, String> response = new HashMap<>();
        if ("success".equals(result)) {
            response.put("status", "success");
            response.put("message", "Registration successful");
            return ResponseEntity.ok(response);
        }
        response.put("status", "error");
        response.put("message", result);
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> body) {
        String email = body.get("userEmail");
        String password = body.get("userPassword");
        User user = userService.loginUser(email, password);
        Map<String, String> response = new HashMap<>();
        if (user != null) {
            response.put("status", "success");
            response.put("message", "Login successful");
            response.put("userName", user.getUserName());
            response.put("userEmail", user.getUserEmail());
            return ResponseEntity.ok(response);
        }
        response.put("status", "error");
        response.put("message", user == null ? "Email not registered" : "Password incorrect");
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<Map<String, String>> registerAdmin(@RequestBody Map<String, Object> body) {
        Admin admin = new Admin(
            Integer.parseInt(body.get("adminId").toString()),
            body.get("adminName").toString(),
            body.get("adminEmail").toString(),
            body.get("adminPassword").toString(),
            body.get("adminConfirmPassword").toString()
        );
        String result = adminService.registerAdmin(admin);
        Map<String, String> response = new HashMap<>();
        if ("success".equals(result)) {
            response.put("status", "success");
            response.put("message", "Admin registered successfully");
            return ResponseEntity.ok(response);
        }
        response.put("status", "error");
        response.put("message", result);
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<Map<String, String>> loginAdmin(@RequestBody Map<String, String> body) {
        String email = body.get("adminEmail");
        String password = body.get("adminPassword");
        Admin admin = adminService.loginAdmin(email, password);
        Map<String, String> response = new HashMap<>();
        if (admin != null) {
            response.put("status", "success");
            response.put("message", "Login successful");
            response.put("adminName", admin.getAdminName());
            response.put("adminEmail", admin.getAdminEmail());
            return ResponseEntity.ok(response);
        }
        response.put("status", "error");
        response.put("message", "Invalid email or password");
        return ResponseEntity.badRequest().body(response);
    }
}
