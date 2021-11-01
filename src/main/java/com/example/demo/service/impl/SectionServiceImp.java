package com.example.demo.service.impl;

import com.example.demo.entity.Section;
import com.example.demo.error.CustomException;
import com.example.demo.repository.SectionRepository;
import com.example.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SectionServiceImp implements SectionService {
    @Autowired
    private final SectionRepository sectionRepository;

    public SectionServiceImp(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    @Override
    public Section create(Section section) throws CustomException {
        try {
            Section s=new Section();
            s.setSectionName(section.getSectionName());
            return  sectionRepository.save(s);
        } catch (Exception e) {
            throw new CustomException(e.getLocalizedMessage(), 500, new Date().getTime());
        }
    }
}
