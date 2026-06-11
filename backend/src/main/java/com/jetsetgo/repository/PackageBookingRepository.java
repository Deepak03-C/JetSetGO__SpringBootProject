package com.jetsetgo.repository;

import com.jetsetgo.entity.PackageBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageBookingRepository extends JpaRepository<PackageBooking, Long> {
}
