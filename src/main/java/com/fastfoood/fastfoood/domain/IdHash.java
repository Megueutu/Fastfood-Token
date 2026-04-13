package com.fastfoood.fastfoood.domain;
import java.util.UUID;

public class IdHash {
    private String hash;

    public IdHash(String typeHash) {
        this.hash = typeHash.toLowerCase() + "-" + (UUID.randomUUID().toString());
    }

    public String getHash() {
        return hash;
    }
}
