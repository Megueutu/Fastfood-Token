package com.fastfoood.fastfoood.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class StorageConfiguration {

    @Value("${storage.path}")
    private String storagePath;

    @Value("${storage.default-name}")
    private String defaultName;

    public Path getStoragePath() {
        Path path = Path.of(storagePath);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("It wasn't possible to create the directory: " + path, e);
        }
        return path;
    }
}
