package com.fastfoood.fastfoood.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.fastfoood.fastfoood.factory.IdHashFactory;

import lombok.Getter;

@Getter
public class Receipt extends Order {
    private IdHash idReceipt;
    private double finalPrice;

    private IdHashFactory hashFactory;

    public Receipt(Order order) {
        super(order.getClientIdentification());
        this.idReceipt = hashFactory.createOrderHash();
        this.finalPrice = order.getFinalPrice();
    }

    public String getFileName() {
        LocalDateTime nowaTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM:HHmm-yyyy");
        String nowaFormat = nowaTime.format(formatter);

        return String.format("%s:%s", nowaFormat, this.idReceipt.getHash());
    }
}