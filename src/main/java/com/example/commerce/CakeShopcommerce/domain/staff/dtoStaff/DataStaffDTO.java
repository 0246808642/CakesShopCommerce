package com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff;

import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.staff.enums.Adjutancy;
import com.example.commerce.CakeShopcommerce.domain.staff.Staff;

public record DataStaffDTO(Long id, String name, String surname, String email, String registration, Adjutancy adjutancy, Address address) {

    public DataStaffDTO(Staff staff){
        this(staff.getId(),staff.getName(),staff.getSurname(), staff.getEmail(), staff.getRegistration(), staff.getAdjutancy(), staff.getAddress());
    }
}
