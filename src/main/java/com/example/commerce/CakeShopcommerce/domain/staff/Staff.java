package com.example.commerce.CakeShopcommerce.domain.staff;


import com.example.commerce.CakeShopcommerce.domain.address.Address;
import com.example.commerce.CakeShopcommerce.domain.staff.enums.Adjutancy;
import jakarta.persistence.*;
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
    private String email;
    private String surname;
    private String registration;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Adjutancy adjutancy;




}
