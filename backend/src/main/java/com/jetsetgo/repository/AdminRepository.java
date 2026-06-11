package com.jetsetgo.repository;

import com.jetsetgo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByAdminEmail(String adminEmail);
}
