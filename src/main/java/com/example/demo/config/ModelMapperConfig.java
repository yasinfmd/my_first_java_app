package com.example.demo.config;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.addMappings(new PropertyMap<StudentDTO, Student>() {
            @Override
            protected void configure() {
                map().setName(source.getFirsName());
                map().setSurname(source.getLastName());
            }
        });

       modelMapper.addMappings(new PropertyMap<Student, StudentDTO>() {
            @Override
            protected void configure() {
                map().setStudentId(source.getId());
                map().setFirsName(source.getName());
                map().setLastName(source.getSurname());
            }
        });
        return  modelMapper;
    }
}
