package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.error.CustomError;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService  {
     StudentDTO create(StudentDTO student) throws CustomError;

     List<StudentDTO> getAll() throws  CustomError;

     StudentDTO get(Long studentId) throws  CustomError;

     boolean isExist (Long studentId) throws  CustomError;


     boolean delete (Long studentId) throws  CustomError;

     StudentDTO update(Long studentId, StudentDTO student) throws  CustomError;

     Page<StudentDTO> pagination(int currentPage,int pageSize) throws CustomError;

     Page<StudentDTO> paginate(Pageable pageable) throws CustomError;


}
