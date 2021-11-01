package com.example.demo.dto;


public class StudentDTO {


    private  Long studentId;
    private String firsName;

    private String lastName;

    private String fullName;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }



    public String getFullName() {return firsName.concat(" ").concat(lastName);}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
