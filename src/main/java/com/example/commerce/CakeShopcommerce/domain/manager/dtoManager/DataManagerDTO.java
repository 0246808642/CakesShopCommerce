package com.example.commerce.CakeShopcommerce.domain.manager;

import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.address.AddressDTO;
import com.example.commerce.CakeShopcommerce.domain.enums.ManagerialRole;
import com.example.commerce.CakeShopcommerce.domain.validator.IdadeMinima;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataManagerDTO(Long id, String name, String surname, String cpf, String email, String emailBusiness, int age, String telephone, String numberRegistration, ManagerialRole managerRole, Address address){
    public DataManagerDTO(Manager manager){
        this(manager.getId(), manager.getName(), manager.getSurname(), manager.getCpf(), manager.getEmail(), manager.getEmailBusiness(), manager.getAge(), manager.getTelephone(), manager.getNumberRegistration(),manager.getManagerialRole(),manager.getAddress());
    }
}

