package com.clickkart.identityms.dao;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
abstract class AbstractBaseEntity {


    @Column(nullable = false,updatable = false)
    @CreatedDate
    protected LocalDateTime createdOn = LocalDateTime.now();

    @LastModifiedDate
    protected LocalDateTime updatedOn =  LocalDateTime.now();
}
