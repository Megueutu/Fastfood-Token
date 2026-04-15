package com.fastfoood.fastfoood.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fastfoood.fastfoood.repository.ReceiptRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {
    private ReceiptRepository receiptRepository;

    
}