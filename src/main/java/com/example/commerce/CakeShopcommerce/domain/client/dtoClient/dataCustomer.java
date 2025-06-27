package com.example.commerce.CakeShopcommerce.domain.client.dtoClient;

import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.client.Client;

public record dataCustomer( Long id,String name, String surname,  String telephone, String cpf, int age, Address address) {

    public dataCustomer(Client client) {
        this(client.getId(),client.getName(), client.getSurname(), client.getTelephone(), client.getCpf(), client.getAge(), client.getAddress());

    }


}
