package com.drodriguez.pruebatecnica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Price not found with the given data")
public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(){
        super("Price not found with the given data");
    }
}
