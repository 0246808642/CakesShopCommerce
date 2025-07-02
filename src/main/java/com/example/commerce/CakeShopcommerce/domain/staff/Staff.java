package com.example.commerce.CakeShopcommerce.domain.staff;


import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.staffRegistrationData;
import com.example.commerce.CakeShopcommerce.domain.staff.enums.Adjutancy;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Staff")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Staff {

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
    private String numberRegistration;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Adjutancy adjutancy;


    public Staff(@Valid staffRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.telephone = data.telephone();
        this.cpf = data.cpf();
        this.age = data.age();
        this.surname = data.surname();
        this.email = data.email();
        this.numberRegistration = data.numberRegistration();
        this.adjutancy = data.adjutancy();
        this.address= new Address(data.address());

    }
}
