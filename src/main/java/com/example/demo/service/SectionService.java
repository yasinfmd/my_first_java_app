package com.example.demo.service;

import com.example.demo.entity.Section;
import com.example.demo.error.CustomException;


public interface SectionService {
    Section create(Section section) throws  CustomException;

}
