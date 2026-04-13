package com.fastfoood.fastfoood.services;

import org.springframework.stereotype.Service;

import com.fastfoood.fastfoood.domain.Order;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public Order createOrder() {
        return new Order();
    }
}