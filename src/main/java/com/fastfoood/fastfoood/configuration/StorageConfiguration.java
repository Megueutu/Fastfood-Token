package com.fastfoood.fastfoood.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Configuration
@AllArgsConstructor
public class StorageConfiguration {

    private final StorageProperties storageProperties;

    public Path getStoragePath() {
        Path path = Path.of(storageProperties.getPath());
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("It wasn't possible to create the directory: " + path, e);
        }
        return path;
    }
}
