package com.sai.covidproject.covid.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends Throwable {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(){
        System.out.println("this is resource not found exception");;
    }
}
