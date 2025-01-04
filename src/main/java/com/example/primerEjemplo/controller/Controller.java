package com.example.primerEjemplo.controller;

import com.example.primerEjemplo.NameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class Controller {

    @Autowired
    private NameValidator nameValidator;
    private final List<String> names= new ArrayList<>();

    @GetMapping("/hola")
    public String saludo(){
        names.forEach(System.out::println);
        return names.getFirst();
    }
    @GetMapping("/hola/{name}")
    public String devolverSaludo(@PathVariable String name) throws Exception {
        if(!nameValidator.validate(name)){
            throw new Exception("noValid");
        }

        return String.format("otro mensaje guy: %s", name);
    }
    @PostMapping("/hola")
    public String heyBack(@RequestBody String name){
        names.add(name);
        return  String.format("You up bro: %s", name);
    }

    public void setNameValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }
}
