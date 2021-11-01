package com.example.demo.entity;

import com.example.demo.anotation.CustomName;
import com.example.demo.baseentities.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Student extends BaseEntity {

    @NotNull
    @CustomName(message = "Custom Anotation")
    @Size(min = 2,max = 20 , message = "Mesaj 2 ile 20 arasında olmalı")
    private String name;

    @NotNull
    @Size(min = 2,max = 20 , message = "Mesaj 2 ile 20 arasında olmalı")
    private  String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
