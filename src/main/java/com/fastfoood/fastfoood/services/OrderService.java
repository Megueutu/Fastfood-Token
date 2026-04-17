package com.fastfoood.fastfoood.services;

import org.springframework.stereotype.Service;

import com.fastfoood.fastfoood.domain.IdHash;
import com.fastfoood.fastfoood.domain.Order;
import com.fastfoood.fastfoood.domain.Receipt;
import com.fastfoood.fastfoood.repository.ReceiptInterfaceRepository;

// POST /orders              → cria o pedido vazio com nome do cliente
// POST /orders/{id}/products → adiciona produto por produto
// POST /orders/{id}/checkout → finaliza

@Service
public class OrderService {
    private ReceiptInterfaceRepository receiptRepository;

    public Order getOrder(IdHash idHash) {
        try {
            return new Order("null");
        }
        catch (Exception e) {
            return null;
        }
    }

    public IdHash createReceipt(Order order) {
        try {
            Receipt receipt = new Receipt(order);
            return receiptRepository.save(receipt);
        }
        catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
    }

    public IdHash deleteReceipt(IdHash idHash) {
        try {
            if (receiptRepository.verifyExistence(idHash)) {
                throw new Exception("File not found");
            }
            return receiptRepository.deleteById(idHash);
        }
        catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
    }

    public Receipt getReceiptInfo(String fileName) {
        Receipt receipt = receiptRepository.findByFileName(fileName);
        return receipt;
    }
}