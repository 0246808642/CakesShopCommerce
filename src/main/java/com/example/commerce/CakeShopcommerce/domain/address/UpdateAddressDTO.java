package com.example.commerce.CakeShopcommerce.domain.address;

import jakarta.validation.constraints.Pattern;

public record UpdateAddressDTO(
        String state,
        String city,
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato de CEP inválido. Use 99999-999")
        String zipCode,
        String road,
        String district,
        String houseNumber) {
}
