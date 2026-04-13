package com.fastfoood.fastfoood.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastfoood.fastfoood.services.HelloWorldService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
// APIs STATELESS (REST), cada nova requisição, recebe todos os dados necessários para processar a requisição, sem depender de informações armazenadas no servidor.
// APIs STATEFULL,        estado é mantido no servidor, reconhece o cliente a cada requisição, permitindo interações mais complexas, mas pode ser mais difícil de escalar e manter.

@Controller // Viabiliza retorno de resposta para o cliente
@ResponseBody
@RequestMapping("/hello-world") // Especifica qual request mapeia
public class HelloWorldApplication {
    
    @Autowired
    private HelloWorldService helloWorldService;

    // Esse método escuta o endpoint "/hello-world" no verbo get, assim, aplica o método
    @GetMapping
    public String helloVideo() {
        return helloWorldService.helloWorld("Nome");
    }

    /*
    Exemplo básico de endereço:
    localhost:8080/hello-world
    
    localhost:8080 é o domínio, hello-world é o endpoint
    */

    @PostMapping("")
    public String helloWorldPost(@RequestBody User body) {
        return "Hello World" + body.getName();
    }
    
}
