package com.fastfoood.fastfoood.model;
import java.util.UUID;

import com.fastfoood.fastfoood.configuration.IdHashConfiguration;

import lombok.Getter;

@Getter
public class IdHash {
    private String hash;
    private IdHashConfiguration hashConfig;

    public IdHash(String typeHash, int length) {
        this.hash = typeHash.toUpperCase() + "-" + (UUID.randomUUID().toString().replace("-", "").substring(0, hashConfig.getLength()));
    }
}
