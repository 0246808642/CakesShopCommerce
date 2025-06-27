package com.example.commerce.CakeShopcommerce.domain.address;

import com.example.commerce.CakeShopcommerce.domain.client.DTO.updateClient;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String state;
    private String city;
    private String zipCode;
    private String road;
    private String district;
    private String houseNumber;


    public Address(@NotNull @Valid AddressDTO data) {
        this.state = data.state();
        this.city = data.city();
        this.zipCode = data.zipCode();
        this.road = data.road();
        this.district = data.district();
        this.houseNumber = data.houseNumber();
    }

    public void updateAddress(updateClient data) {
       if(data.address() == null){
           return;
       }
        if(data.address().city() != null){
            this.city = data.address().city();
        }
        if(data.address().zipCode() != null){
            this.zipCode = data.address().zipCode();
        }
        if(data.address().road() != null){
            this.road = data.address().road();
        }
        if(data.address().district() != null){
            this.district = data.address().district();
        }
        if(data.address().state() != null){
            this.houseNumber = data.address().houseNumber();
        }
    }
}
