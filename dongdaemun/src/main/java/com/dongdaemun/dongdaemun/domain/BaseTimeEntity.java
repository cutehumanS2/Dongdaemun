package com.dongdaemun.dongdaemun.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    //private LocalDateTime createDate;
    private String createDate;

    @CreatedDate
    //private LocalDateTime createDate;
    private String createDate2;

    @LastModifiedDate
    //private LocalDateTime modifieDate;
    private String modifieDate;

    @LastModifiedDate
    //private LocalDateTime modifieDate;
    private String modifieDate2;

    //엔티티 insert 이전 실행
    @PrePersist
    public void onPrePersist(){
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.modifieDate = this.createDate;
        this.createDate2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.modifieDate2 = this.createDate2;
    }

    //엔티티 update 이전 실행
    @PreUpdate
    public void onPreUpdate(){
        this.modifieDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.modifieDate2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

}



