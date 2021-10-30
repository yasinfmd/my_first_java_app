package com.example.demo.service.impl;

import com.example.demo.error.CustomException;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImp implements FileService {

    private Path fileStoragePath;

    private String fileStorageLocation;

    public FileServiceImp(@Value("${file.storage.location:temp}") String fileStorageLocation) throws IOException {
        this.fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        this.fileStorageLocation = fileStorageLocation;
        Files.createDirectories(fileStoragePath);
    }

    @Override
    public String storeFile(MultipartFile file) throws IOException,CustomException {
        String fileName = UUID.randomUUID().toString() +  "___" + StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = Paths.get(fileStoragePath + "\\" + fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    @Override
    public Resource downloadFile(String fileName) throws MalformedURLException, CustomException {
        Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(fileName);
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists()) {
            return resource;

        }
        throw new CustomException("Error",500, new Date().getTime());
    }
}
