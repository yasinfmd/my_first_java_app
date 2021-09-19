package com.example.demo.service.impl;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.error.CustomError;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final ModelMapper modelMapper;


    public StudentServiceImp(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO create(@Valid StudentDTO studentDTO) throws CustomError {
        try {
            Student student = modelMapper.map(studentDTO, Student.class);
            student.setCreatedAt(new Date());
            student.setCreatedBy(student.getName());
            return modelMapper.map(studentRepository.save(student), StudentDTO.class);
        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());
        }
    }

    @Override
    public List<StudentDTO> getAll() throws CustomError {
        try {
            List<Student> studentList = studentRepository.findAll();
            List<StudentDTO> studentDTOList = studentList.stream().map(student -> modelMapper.map(student, StudentDTO.class)).collect(Collectors.toList());
            return studentDTOList;
        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());

        }
    }

    @Override
    public StudentDTO get(Long studentId) throws CustomError {
        try {
            boolean isExist = this.isExist(studentId);
            if (isExist) {
                Student student = studentRepository.getById(studentId);
                return modelMapper.map(student, StudentDTO.class);
            }
            return null;
        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());
        }
    }


    @Override
    public boolean isExist(Long studentId) throws CustomError {
        try {
            boolean isExist = studentRepository.existsById(studentId);
            return isExist;
        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());
        }
    }

    @Override
    public StudentDTO update(Long studentId, StudentDTO student) throws CustomError {
        try {
            Optional<Student> _student = studentRepository.findById(studentId);
            if (_student.isPresent()) {
                _student.get().setName(student.getFirsName());
                _student.get().setSurname(student.getLastName());
                _student.get().setCreatedAt(new Date());
                _student.get().setCreatedBy(student.getFullName());
                return modelMapper.map(studentRepository.save(_student.get()), StudentDTO.class);
            }
            return null;

        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());
        }
    }

    @Override
    public Page<StudentDTO> pagination(int currentPage, int pageSize) throws CustomError {
        try {
            Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("name").descending());
            Page<StudentDTO> students = studentRepository.findAll(pageable).map((student -> modelMapper.map(student, StudentDTO.class)));


            return students;
        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());

        }
    }

    @Override
    public Page<StudentDTO> paginate(Pageable pageable) throws CustomError {
        try {
            Page<StudentDTO> students = studentRepository.findAll(pageable).map((student -> modelMapper.map(student, StudentDTO.class)));
            return students;

        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());

        }
    }

    @Override
    public boolean delete(Long studentId) throws CustomError {
        try {
            boolean isExist = isExist(studentId);
            if (isExist) {
                studentRepository.deleteById(studentId);
                return true;
            }
            //
            //log_10.10.2020 3 numaralı kayıt student db de bulunamadı
            return true;
        } catch (Exception e) {
            throw new CustomError("Bir Hata ", e, e.getMessage());
        }
    }


}
