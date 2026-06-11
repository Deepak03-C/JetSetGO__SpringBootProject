package com.jetsetgo.service;

import com.jetsetgo.entity.HotelBooking;
import com.jetsetgo.entity.PackageBooking;
import com.jetsetgo.entity.User;
import com.jetsetgo.repository.HotelBookingRepository;
import com.jetsetgo.repository.PackageBookingRepository;
import com.jetsetgo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageBookingRepository packageBookingRepository;

    @Autowired
    private HotelBookingRepository hotelBookingRepository;

    public String registerUser(User user) {
        Optional<User> existing = userRepository.findByUserEmail(user.getUserEmail());
        if (existing.isPresent()) {
            return "Email already registered";
        }
        userRepository.save(user);
        return "success";
    }

    public User loginUser(String email, String password) {
        Optional<User> user = userRepository.findByUserEmail(email);
        if (user.isEmpty()) return null;
        if (!user.get().getUserPassword().equals(password)) return null;
        return user.get();
    }

    public PackageBooking bookPackage(String place, String days, String name, long contact, String date, int members) {
        PackageBooking booking = new PackageBooking(place, days, name, contact, date, members);
        return packageBookingRepository.save(booking);
    }

    public HotelBooking bookHotel(String name, long contact, String date, int count, String hotelname, double price) {
        HotelBooking booking = new HotelBooking(name, contact, date, count, hotelname, price);
        return hotelBookingRepository.save(booking);
    }
}
