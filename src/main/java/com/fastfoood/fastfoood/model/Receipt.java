package com.fastfoood.fastfoood.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class Receipt extends Order {
    private IdHash idReceipt;
    private double finalPrice;

    public Receipt(Order order) {
        super(order.getClientIdentification());
        this.idReceipt = new IdHash("RC");
        this.finalPrice = order.getFinalPrice();
    }

    public String getFileName() {
        LocalDateTime nowaTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM:HHmm-yyyy");
        String nowaFormat = nowaTime.format(formatter);

        return String.format("RC-%s:%s", nowaFormat, this.idReceipt.getHash());
    }
}