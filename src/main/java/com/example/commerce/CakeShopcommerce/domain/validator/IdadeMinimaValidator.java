package com.example.commerce.CakeShopcommerce.domain.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdadeMinimaValidator implements ConstraintValidator<IdadeMinima, Integer> {

    private int idadeMinima;

    @Override
    public void initialize(IdadeMinima constraintAnnotation) {
       this.idadeMinima = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
       if(value == null){
           return false;
       }
       return value>= idadeMinima;
    }
}
