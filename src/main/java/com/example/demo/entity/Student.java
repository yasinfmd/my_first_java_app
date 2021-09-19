package com.example.demo.entity;

import com.example.demo.baseentities.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Student extends BaseEntity {

    @NotNull
    @Size(min = 2,max = 20 , message = "Mesaj 2 ile 20 arasında olmalı")
    private String name;

    @NotNull
    @Size(min = 2,max = 20 , message = "Mesaj 2 ile 20 arasında olmalı")
    private  String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
