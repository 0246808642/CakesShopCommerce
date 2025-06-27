package com.example.commerce.CakeShopcommerce.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        @Pattern(
                regexp = "\\d{2}",
                message = "Deve ser so o UF da capital"
        )
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
