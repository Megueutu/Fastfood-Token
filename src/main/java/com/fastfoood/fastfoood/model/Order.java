package com.fastfoood.fastfoood.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private IdHash idOrder;
    private String clientIdentification;
    private ArrayList<Product> productList;

    public Order(String clientName) {
        this.idOrder = new IdHash("OR");
        this.clientIdentification = clientName;
        this.productList = new ArrayList<>();
    }

    public double getFinalPrice() {
        double sum = 0;
        for (Product product : this.productList) {
            sum += product.getPrice() * product.getQnty();
        }
        return sum;
    }
}