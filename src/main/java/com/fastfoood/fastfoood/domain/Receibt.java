package com.fastfoood.fastfoood.domain;

import lombok.Getter;

@Getter
public class Receibt {
    private IdHash idHash;
    private String clientName;

    public Receibt(String type, String clientName) {
        this.idHash = new IdHash(type);
        this.clientName = clientName;
    }
}
