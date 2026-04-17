package com.fastfoood.fastfoood.domain;

import java.util.ArrayList;

import com.fastfoood.fastfoood.factory.IdHashFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private IdHash idOrder;
    private String clientIdentification;
    private ArrayList<Product> productList;

    private IdHashFactory hashFactory;

    public Order(String clientName) {
        this.idOrder = hashFactory.createOrderHash();
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