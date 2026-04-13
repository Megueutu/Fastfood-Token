package com.fastfoood.fastfoood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// É a classe que contém a lógica sobre como vai funcionar as coisas
// As services que fazem o trabalho pesado

@Service
public class HelloWorldService {

    
    public String helloWorld(String name) {
        return "Hello World " + name;
    }   
}
