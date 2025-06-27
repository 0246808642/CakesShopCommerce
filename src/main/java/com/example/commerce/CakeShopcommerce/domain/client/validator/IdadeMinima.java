package com.example.commerce.CakeShopcommerce.domain.client.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdadeMinimaValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdadeMinima {

    String message() default "A idade dever no minimo {} anos.";

    int value();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
