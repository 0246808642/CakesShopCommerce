package com.example.commerce.CakeShopcommerce.domain.staff.repository;

import com.example.commerce.CakeShopcommerce.domain.staff.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRepositoryStaff extends JpaRepository<Staff,Long> {
    Page<Staff> findAllByActiveTrue(Pageable pag);
}
