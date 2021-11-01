package com.example.demo.controllers;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Section;
import com.example.demo.error.CustomException;
import com.example.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/section")
public class SectionController {
    @Autowired
    SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid  Section section) throws CustomException {
        return ResponseEntity.ok(sectionService.create(section));
    }
}
