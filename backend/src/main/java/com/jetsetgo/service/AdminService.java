package com.jetsetgo.service;

import com.jetsetgo.entity.Admin;
import com.jetsetgo.entity.Hotel;
import com.jetsetgo.entity.TourPackage;
import com.jetsetgo.repository.AdminRepository;
import com.jetsetgo.repository.HotelRepository;
import com.jetsetgo.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public String registerAdmin(Admin admin) {
        Optional<Admin> existing = adminRepository.findByAdminEmail(admin.getAdminEmail());
        if (existing.isPresent()) {
            return "Email already registered";
        }
        adminRepository.save(admin);
        return "success";
    }

    public Admin loginAdmin(String email, String password) {
        Optional<Admin> admin = adminRepository.findByAdminEmail(email);
        if (admin.isEmpty()) return null;
        if (!admin.get().getAdminPassword().equals(password)) return null;
        return admin.get();
    }

    public TourPackage addTourPackage(byte[] image, String place, String days) {
        TourPackage pkg = new TourPackage(place, image, days);
        return tourPackageRepository.save(pkg);
    }

    public Hotel addHotel(byte[] image, String hotelname, String price) {
        Hotel hotel = new Hotel(image, hotelname, price);
        return hotelRepository.save(hotel);
    }

    public List<TourPackage> getAllPackages() {
        return tourPackageRepository.findAll();
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
