package com.fastfoood.fastfoood.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fastfoood.fastfoood.domain.IdHash;
import com.fastfoood.fastfoood.domain.Order;
import com.fastfoood.fastfoood.domain.Receipt;
import com.fastfoood.fastfoood.repository.ReceiptInterfaceRepository;

@Service
public class OrderService {
    private ReceiptInterfaceRepository receiptRepository;

    public IdHash createReceipt(Order order) { 
        Receipt receipt = new Receipt(order);
        return receiptRepository.save(receipt);
    }

    public IdHash deleteReceipt(IdHash idHash) {
        return receiptRepository.delete(idHash);
    }
}