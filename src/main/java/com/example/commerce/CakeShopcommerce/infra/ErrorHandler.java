package com.example.commerce.CakeShopcommerce.infra;


import com.example.commerce.CakeShopcommerce.infra.DTO.ErrorsDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso nao encontrado: "+ ex.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex, EntityNotFoundException exception){
        var error = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(error.stream().map(ErrorsDTO:: new).toList());
    }
}
