package com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff;

import com.example.commerce.CakeShopcommerce.domain.address.UpdateAddressDTO;
import jakarta.validation.constraints.NotNull;

public record UpdateStaff(@NotNull Long id , String name, String surname, int age, String telephone, UpdateAddressDTO address) {

}
