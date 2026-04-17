package com.fastfoood.fastfoood.repository;

import java.util.List;

import com.fastfoood.fastfoood.domain.IdHash;
import com.fastfoood.fastfoood.domain.Receipt;

public interface ReceiptInterfaceRepository {
    IdHash save(Receipt receipt);
    IdHash deleteById(IdHash idHash);
    
    List<IdHash> saveMany(List<Receipt> listReceipt);
    List<IdHash> deleteMany(List<Receipt> listReceipt);
    
    List<IdHash> saveManyById(List<IdHash> listIdHash);
    List<IdHash> deleteManyById(List<IdHash> listIdHash);
    
    Receipt findById(IdHash idHash);
    Receipt findByFileName(String fileName);

    List<Receipt> findAll();
    List<Receipt> findAllByFileName(List<String> listFileName);
    boolean verifyExistence(IdHash idHash);
}