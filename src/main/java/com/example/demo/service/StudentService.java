package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.error.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService  {
     StudentDTO create(StudentDTO student) throws CustomException;

     List<StudentDTO> getAll() throws  CustomException;

     StudentDTO get(Long studentId) throws  CustomException;

     boolean isExist (Long studentId) throws  CustomException;


     boolean delete (Long studentId) throws  CustomException;

     StudentDTO update(Long studentId, StudentDTO student) throws  CustomException;

     Page<StudentDTO> pagination(int currentPage,int pageSize) throws CustomException;

     Page<StudentDTO> paginate(Pageable pageable) throws CustomException;


}
