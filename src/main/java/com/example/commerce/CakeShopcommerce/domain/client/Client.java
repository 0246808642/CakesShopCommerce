package com.example.commerce.CakeShopcommerce.domain.client;


import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.client.dtoClient.customerRegistrationData;
import com.example.commerce.CakeShopcommerce.domain.client.dtoClient.updateClient;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Client")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active;
    private String name;
    private String surname;
    private String cpf;
    private String email;
    private int age;
    private String telephone;
    @Embedded
    private Address address;


    public Client(@Valid customerRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.surname = data.surname();
        this.cpf = data.cpf();
        this.age = data.age();
        this.email = data.email();
        this.telephone = data.telephone();
        this.address = new Address(data.address());

    }

    public void updateData(updateClient data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.surname() != null) {
            this.surname = data.surname();
        }
        if (data.telephone() != null) {
            this.telephone = data.telephone();
        }
        if (data.email() != null) {
            this.email = data.email();
        }
        this.address.updateAddress(data);

    }

    public void remove() {
        this.active = false;
    }
}
