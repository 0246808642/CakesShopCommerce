package com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff;

import com.example.commerce.CakeShopcommerce.domain.address.AddressDTO;
import com.example.commerce.CakeShopcommerce.domain.validator.IdadeMinima;
import com.example.commerce.CakeShopcommerce.domain.staff.enums.Adjutancy;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record staffRegistrationData(
        @NotBlank
        String  name,
        @NotBlank
        String  surname,
        @NotNull
        @IdadeMinima(16)
        int age,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^\\d{4}-\\d{1}$", message = "O formato da matricula deve ser 0000-1")
        String numberRegistration,
        @NotNull
        Adjutancy adjutancy,
        @NotBlank
        @Pattern(
                regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}",
                message = "Telefone deve estar no formato (99) 99999-9999"
        )
        String telephone ,
        @NotBlank
        String cpf,
        @Valid
        @NotNull
        AddressDTO address
)
{
}
