package com.example.demo.controllers;

import com.example.demo.config.BaseResponseConfig;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.Student;
import com.example.demo.error.CustomException;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@RestController
@RequestMapping("/api/student")
public class StudentController {
    // Java Classpath

    //java basepath

    //java file save api

    // logforj

    // file system

    //statik class file loglama
    // requestpart (name="inbag" ) Student student
    // REquestBody file / inbag :{
    // ad:"yasin",soyad:"dalkılıç"
    // }
    // file gönderirken ?? requestpart ? (name="file") Multipartfile file

    //

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);


    @Autowired
    private final StudentService studentService;

    @Autowired
    private BaseResponseConfig<Object> baseResponseConfig;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<StudentDTO> get(@PathVariable(value = "studentId") Long studentId) throws CustomException {
        //istek geldi log
        return ResponseEntity.ok(studentService.get(studentId));
    }

    @GetMapping("/getAll")
    public BaseResponse<Object> getAll() throws CustomException {
        //istek geldi
        log.info("StudentController Get All");
        Date requestDate = new Date();
        return baseResponseConfig.getBaseResponse(studentService.getAll(), new Date(),
                true, 1, new Date().getTime() - requestDate.getTime(), "");
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@RequestBody @Valid StudentDTO student) throws CustomException {
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping("/paginate")
    public ResponseEntity<Page<StudentDTO>> paginate(@RequestParam int currentPage, @RequestParam int pageSize) throws CustomException {
        return ResponseEntity.ok(studentService.pagination(currentPage, pageSize));
    }

    //http://localhost:9090/api/student/pagination?currentPage=0&pageSize=3&sort=name,desc
    @GetMapping("/pagination")
    public ResponseEntity<Page<StudentDTO>> pagination(Pageable pageable) throws CustomException {
        return ResponseEntity.ok(studentService.paginate(pageable));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> delete(@PathVariable(value = "studentId") Long studentId) throws CustomException {
        return ResponseEntity.ok(studentService.delete(studentId) == true ? "Success" : "Fail");
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentDTO> update(@PathVariable(value = "studentId") Long studentId, @RequestBody @Valid StudentDTO studentDTO) throws CustomException {
        return ResponseEntity.ok(studentService.update(studentId, studentDTO));
    }


}
