package com.fastfoood.fastfoood.repository;

import java.util.List;

import com.fastfoood.fastfoood.model.Order;
import com.fastfoood.fastfoood.model.Receipt;

public interface ReceiptInterfaceRepository {
    boolean save(Receipt receipt);
    Receipt findById(String id);
    List<Order> findAll();
}

