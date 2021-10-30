package com.example.demo.service;

import com.example.demo.error.CustomException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FileService {
    String storeFile (MultipartFile file) throws IOException,CustomException;

    Resource downloadFile (String fileName) throws MalformedURLException, CustomException;
}
