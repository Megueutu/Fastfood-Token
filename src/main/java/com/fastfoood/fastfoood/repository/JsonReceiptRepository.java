package com.fastfoood.fastfoood.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fastfoood.fastfoood.domain.IdHash;
import com.fastfoood.fastfoood.domain.Receipt;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
class JsonReceiptRepository implements ReceiptInterfaceRepository {
    private final Path filePath;

    public IdHash save(Receipt receipt) {
        try {
            validateStoragePath();        
            
            Gson gson = new Gson();
            String fileName = receipt.getFileName() + ".json";
            FileWriter writer = new FileWriter(fileName);
            IdHash nowaIdHash = receipt.getIdOrder();

            if (verifyExistence(fileName)) {
                throw new Exception("The file already exists.");
            }

            System.err.println(fileName + " add in " + this.filePath);

            gson.toJson(receipt, writer);
            writer.close();

            return nowaIdHash;
        }

        catch (Exception e) {
            System.err.println("An error ocurried: " + e);
            return null;
        }
    }



    public IdHash deleteById(IdHash idHash) { return deleteById(idHash); }
    public IdHash deleteById(String idHash) {
        try {
            Path file = Files.list(filePath)
                .filter(path -> path.getFileName().toString().contains(idHash))
                .findFirst()
                .orElse(null);

            if (file == null) return null;

            Files.delete(file);
            return new IdHash(idHash);
        }

        catch (IOException e) {
            throw new RuntimeException("Erro ao deletar receipt: " + e.getMessage());
        }
    }



    public List<IdHash> saveMany(List<Receipt> listReceipt) {
        List<IdHash> sucessfulList = new ArrayList<IdHash>();
        
        for (Receipt receipt : listReceipt) {
            try {
                IdHash trySaving = save(receipt);
                if (trySaving != null) {
                    sucessfulList.add(trySaving);
                }
                continue;
            }
            
            catch (Exception e) {
                continue;
            }
        }

        return sucessfulList;
    }



    public List<IdHash> deleteMany(List<Receipt> listReceipt) {
        List<IdHash> sucessfulList = new ArrayList<IdHash>();
        
        for (Receipt receipt : listReceipt) {
            try {
                IdHash trySaving = deleteById(receipt.getIdReceipt()); // Talvez haja erro de lógica por conta do IdReceipt e IdOrder (acredito que não)
                if (trySaving != null) {
                    sucessfulList.add(trySaving);
                }
                continue;
            }
            
            catch (Exception e) {
                continue;
            }
        }

        return sucessfulList;
    }



    public List<IdHash> saveManyById(List<IdHash> listIdHash) {
        List<IdHash> sucessfulList = new ArrayList<IdHash>();
        
        for (IdHash idHash : listIdHash) {
            try {
                IdHash trySaving = save(findById(idHash));
                if (trySaving != null) {
                    sucessfulList.add(trySaving);
                }
                continue;
            }
            
            catch (Exception e) {
                continue;
            }
        }

        return sucessfulList;
    }
    
    
    
    public List<IdHash> deleteManyById(List<IdHash> listIdHash) {
        List<IdHash> sucessfulList = new ArrayList<IdHash>();
        
        for (IdHash idHash : listIdHash) {
            try {
                IdHash trySaving = deleteById(idHash);
                if (trySaving != null) {
                    sucessfulList.add(trySaving);
                }
                continue;
            }
            
            catch (Exception e) {
                continue;
            }
        }

        return sucessfulList;
    }



    public Receipt findById(IdHash idHash) { return findById(idHash.getHash()); }
    public Receipt findById(String idHash) {
        try {
            Gson gson = new Gson();
            Path file = Files.list(filePath)
                .filter(path -> path.getFileName().toString().contains(idHash))
                .findFirst()
                .orElse(null);

            if (file == null) return null;

            String json = Files.readString(file);
            return gson.fromJson(json, Receipt.class);
        }
        
        catch (IOException e) {
            throw new RuntimeException("Erro ao buscar receipt: " + e.getMessage());
        }
    }



    public List<Receipt> findAll() {
        List<Receipt> allReceipts = new ArrayList<>();

        for (String nowaHash : pushAllFilesHash()) {
            allReceipts.add(findById(nowaHash));
        }

        return allReceipts;
    }



    private List<String> pushAllFilesHash() {
        try {
            List<String> fileNames = Files.list(filePath)
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());
            return fileNames;
        }

        catch (Exception e) {
            System.err.println("An error ocurried: " + e);
            return null;
        }
    }



    public boolean verifyExistence(IdHash idHash) { return verifyExistence(idHash); }
    public boolean verifyExistence(String idHash) {
        return Files.exists(filePath.resolve(idHash));
    }



    private void validateStoragePath() {
        if (!Files.exists(filePath)) {
            throw new RuntimeException("Pasta nao encontrada: " + filePath);
        }
    }
}