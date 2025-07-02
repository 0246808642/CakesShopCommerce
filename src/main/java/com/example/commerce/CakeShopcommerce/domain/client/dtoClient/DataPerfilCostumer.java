package com.example.commerce.CakeShopcommerce.domain.client.dtoClient;

import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.client.Client;

public record DataPerfilCostumer(Long id, String name, String surname, String email, String cpf, int age, String telephone, Address address) {
    public DataPerfilCostumer(Client client){
        this(client.getId(), client.getName(), client.getSurname(), client.getEmail(), client.getCpf(), client.getAge(), client.getTelephone(), client.getAddress());
    }
}
