package com.example.demo.controllers;

import com.example.demo.config.BaseResponseConfig;
import com.example.demo.entity.BaseResponse;
import com.example.demo.error.CustomException;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private final FileService fileService;


    @Autowired
    private BaseResponseConfig<Object> baseResponseConfig;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public BaseResponse<Object> upload(@RequestParam("file") MultipartFile file) throws CustomException, IOException {
        Date requestDate = new Date();
        String fileName = fileService.storeFile(file);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/")
                .path("download/")
                .path(fileName)
                .toUriString();
        String contentType = file.getContentType();
        Map<String, Object> response = new HashMap<>();
        response.put("contentType", contentType);
        response.put("url", url);
        response.put("size", file.getSize());
        response.put("fileName", fileName);
        return baseResponseConfig.getBaseResponse(response, new Date(),
                true, 1, new Date().getTime() - requestDate.getTime(), "");

    }

    @PostMapping("/multiple")
    public BaseResponse<Object> multipleUpload(@RequestParam("files ") MultipartFile[] files) throws IOException, CustomException{
        Date requestDate = new Date();
        List<Map<String, Object>> list=new ArrayList<>();
        Arrays.asList(files).stream()
                .forEach(file -> {
                    String fileName = null;
                    try {
                        fileName = fileService.storeFile(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CustomException e) {
                        e.printStackTrace();
                    }
                    String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/api/file/")
                            .path("download/")
                            .path(fileName)
                            .toUriString();
                    String contentType = file.getContentType();
                    Map<String, Object> response = new HashMap<>();
                    response.put("contentType", contentType);
                    response.put("url", url);
                    response.put("size", file.getSize());
                    response.put("fileName", fileName);
                    list.add(response);
                });
        return baseResponseConfig.getBaseResponse(list, new Date(),
                true, 1, new Date().getTime() - requestDate.getTime(), "");
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable("fileName") String fileName, HttpServletRequest request) throws IOException, CustomException {
        Resource resource = fileService.downloadFile(fileName);
        String mimeType = "";
        try {
            mimeType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + resource.getFilename())

                .body(resource);
    }

}
