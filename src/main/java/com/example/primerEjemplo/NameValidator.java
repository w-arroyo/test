package com.example.primerEjemplo;

import org.springframework.stereotype.Service;

@Service
public class NameValidator {

    public boolean validate(String name){
        return name.length() == Math.random();
    }
}
