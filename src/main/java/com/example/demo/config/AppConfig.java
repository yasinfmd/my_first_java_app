package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class AppConfig {
    String fileStorageLocation;

    String customStorage;

    String customUrlLocation;

    public String getCustomUrlLocation() {
        return customUrlLocation;
    }

    public void setCustomUrlLocation(String customUrlLocation) {
        this.customUrlLocation = customUrlLocation;
    }


    public String getCustomStorage() {
        return customStorage;
    }

    public void setCustomStorage(String customStorage) {
        this.customStorage = customStorage;
    }

    public String getFileStorageLocation() {
        return fileStorageLocation;
    }

    public void setFileStorageLocation(String fileStorageLocation) {
        this.fileStorageLocation = fileStorageLocation;
    }
}
