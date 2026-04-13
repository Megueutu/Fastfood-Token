package com.fastfoood.fastfoood.domain;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private IdHash idHash;
    private String clientName;
    private ArrayList<Product> productList;

    /*
        Preciso que o pedido seja criado vazio (praticamente só ID, e depois disso informe o resto)
        
    */

    public Order(String clientName, ArrayList<Product> productList) {
        this.idHash = new IdHash("order");
        this.clientName = clientName;
        this.productList = productList;
    }

    public double calculatePrice() {
        int sum = 0;
        for (Product product : this.productList) {
            sum += product.getPrice();
        }
        return sum;
    }

    public Receibt generateReceibt() {
        return new Receibt("receibt", clientName);
    }
}