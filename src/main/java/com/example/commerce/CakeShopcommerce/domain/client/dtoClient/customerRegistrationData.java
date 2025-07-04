package com.example.commerce.CakeShopcommerce.domain.client.dtoClient;

import com.example.commerce.CakeShopcommerce.domain.address.AddressDTO;
import com.example.commerce.CakeShopcommerce.domain.validator.IdadeMinima;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record customerRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotNull
        @IdadeMinima(18)
        int age,
        @NotBlank
        @Pattern(
                regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}",
                message = "Telefone deve estar no formato (99) 99999-9999"
        )
        String telephone ,

        @NotNull
        @Valid
        AddressDTO address) {
}
