package com.example.demo.baseentities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long Id;

    @Nullable
    @DateTimeFormat(pattern = "dd.MM.yyyyy")
    @Column
    public Date createdAt;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Nullable
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@Nullable Date createdAt) {
        this.createdAt = createdAt;
    }

    @Nullable
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(@Nullable String createdBy) {
        this.createdBy = createdBy;
    }

    @Nullable
    @Column(length = 100)
    public  String createdBy;
}
