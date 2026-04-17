package com.fastfoood.fastfoood.configuration;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;

@Getter
@Configuration
public class IdHashConfiguration {
    
    @Value("${idhash.length}")
    private int length;

    @Value("${idhash.prefix.RECEIPT}")
    private String receiptPrefix;

    @Value("${idhash.prefix.ORDER}")
    private String orderPrefix;

    @Value("${idhash.prefix.CLIENT}")
    private String clientPrefix;
}
