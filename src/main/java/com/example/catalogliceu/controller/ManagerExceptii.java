package com.example.catalogliceu.controller;

import com.example.catalogliceu.exceptions.LiceuInexistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ManagerExceptii {
    @ExceptionHandler(LiceuInexistentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleLiceuNotFoundException(LiceuInexistentException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
