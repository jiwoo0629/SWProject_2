package com.jiwoo1.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate; //created time of post
    @LastModifiedDate
    private LocalDateTime modifiedDate; //modified time of post

    //get String format of LocalDateTime as yyyy-MM-dd
    public String Createddate() {
        return createdDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String Modifieddate() {
        return modifiedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
