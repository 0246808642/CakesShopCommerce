package com.example.commerce.CakeShopcommerce.infra.DTO;

import org.springframework.validation.FieldError;

public record ErrorsDTO(String campo, String mensagem) {
    public  ErrorsDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
