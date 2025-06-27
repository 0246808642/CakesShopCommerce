package com.example.commerce.CakeShopcommerce.domain.client.dtoClient;

import com.example.commerce.CakeShopcommerce.domain.address.UpdateAddressDTO;
import jakarta.validation.constraints.NotNull;

public record updateClient(@NotNull Long id, String name, String surname, String email, String telephone, UpdateAddressDTO address) {
}
