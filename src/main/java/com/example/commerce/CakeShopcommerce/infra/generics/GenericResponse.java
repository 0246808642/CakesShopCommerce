package com.example.commerce.CakeShopcommerce.infra.generics;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    private String message;
    private Object data;

    public GenericResponse(String message) {
        this.message = message;
    }
}
