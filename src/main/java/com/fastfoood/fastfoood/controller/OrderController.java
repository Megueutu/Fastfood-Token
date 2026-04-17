package com.fastfoood.fastfoood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastfoood.fastfoood.domain.IdHash;
import com.fastfoood.fastfoood.domain.Order;
import com.fastfoood.fastfoood.services.OrderService;
import com.fastfoood.fastfoood.services.ReceiptService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<IdHash> createOrder(String request) {
        try {
            return ResponseEntity.status(200).body(new Order(request));
        }
        catch (Exception e) {
            System.err.println("An error ocurried: " + e.getMessage());
            return ResponseEntity.status(200).body(new Order(request));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> reviewOrder(@RequestParam IdHash id) {
        
        return ResponseEntity.status((200).body(orderService.));
    }
    
}


// 1. Se identifica (nome/CPF)
// 2. Adiciona produtos ao pedido
// 3. Revisa o pedido
// 4. Confirma e paga
// 5. Recebe o recibo

// POST /orders                        → cria o pedido com nome do cliente
// POST /orders/{id}/products          → adiciona produto ao pedido
// GET  /orders/{id}                   → consulta o pedido atual (revisão)
// POST /orders/{id}/checkout          → finaliza, gera o Receipt e salva o JSON

// Controller → recebe as requisições acima
// Service    → contém a lógica de cada etapa
// Repository → persiste o Order e o Receipt
