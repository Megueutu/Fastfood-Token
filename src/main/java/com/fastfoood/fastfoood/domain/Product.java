package com.fastfoood.fastfoood.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private int qnty;
}