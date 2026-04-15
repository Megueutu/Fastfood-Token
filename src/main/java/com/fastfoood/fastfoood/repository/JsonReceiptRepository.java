package com.fastfoood.fastfoood.repository;

import java.util.List;
import java.io.FileWriter;
import java.nio.file.Path;

import com.fastfoood.fastfoood.model.Order;
import com.fastfoood.fastfoood.model.Receipt;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tools.jackson.databind.ObjectMapper;

@Getter
@AllArgsConstructor
class JsonReceiptRepository implements ReceiptInterfaceRepository {
    private final Path filePath;
    private final ObjectMapper mapper;
    private List<Order> cache;

    public boolean save(Receipt receipt) {
        try {
            Gson gson = new Gson();
            String fileName = receipt.getFileName() + ".json";
            FileWriter writer = new FileWriter(fileName);

            System.err.println(fileName + " add in " + this.filePath);

            gson.toJson(receipt, writer);
            writer.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Receipt findById(String id) {
        return null;
    }

    public List<Order> findAll() {
        return null;
    }
}