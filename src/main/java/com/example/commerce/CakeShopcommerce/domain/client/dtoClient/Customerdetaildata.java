package com.example.commerce.CakeShopcommerce.domain.client.dtoClient;

import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.client.Client;

public record Customerdetaildata(String  name, String surname, String telephone, String cpf, int Age, Address address) {
    public Customerdetaildata(Client client) {
        this(client.getName(),client.getSurname(), client.getTelephone(), client.getCpf(), client.getAge(),client.getAddress());
    }
}
