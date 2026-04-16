package com.fastfoood.fastfoood.model;

import com.fastfoood.fastfoood.factory.IdHashFactory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Client {
    private IdHash idHash;
    private String name;
    private String cpf;
    private Payment paymentMethod;

    private IdHashFactory hashFactory;

    public Client(String name, String cpf, Payment payment) {
        this.idHash = hashFactory.createClientHash();
        this.name = name;
        this.cpf = cpf;
        this.paymentMethod = payment;
    }
}
