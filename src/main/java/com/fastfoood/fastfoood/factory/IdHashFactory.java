package com.fastfoood.fastfoood.factory;

import org.springframework.stereotype.Component;

import com.fastfoood.fastfoood.configuration.IdHashConfiguration;
import com.fastfoood.fastfoood.domain.IdHash;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class IdHashFactory {
    private final IdHashConfiguration hashConfig;

    public IdHash createOrderHash() {
        return new IdHash(hashConfig.getOrderPrefix(), hashConfig.getLength());
    }

    public IdHash createReceiptHash() {
        return new IdHash(hashConfig.getReceiptPrefix(), hashConfig.getLength());
    }

    public IdHash createClientHash() {
        return new IdHash(hashConfig.getClientPrefix(), hashConfig.getLength());
    }
}
