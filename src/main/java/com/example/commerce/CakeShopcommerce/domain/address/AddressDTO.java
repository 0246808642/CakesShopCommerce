package com.example.commerce.CakeShopcommerce.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressDTO(
        @NotBlank
        @Size(min = 2, max = 2, message = "Deve conter exatamente 2 caracteres")
        String state,
        @NotBlank
        String city,
        @NotBlank
        @Pattern(
                regexp = "\\d{5}-\\d{3}",
                message = "CEP deve estar no formato 99999-999"
        )
        @NotBlank
        String zipCode,
        String road,
        String district,
        String houseNumber
      ) {


}
