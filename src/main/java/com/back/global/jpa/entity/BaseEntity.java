package com.back.global.jpa.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass                                  // 이 클래스 자체는 테이블이 아니고, 필드만 자식 엔티티에게 물려줌
@EntityListeners(AuditingEntityListener.class)     // 저장/수정 시점을 감지해서 날짜를 채워 줌
@Getter
public abstract class BaseEntity {
    @Id                                            // 기본키(PK)
    @GeneratedValue(strategy = IDENTITY)           // 번호를 DB가 1, 2, 3… 자동 증가로 매김
    private int id;

    @CreatedDate
    private LocalDateTime createDate;              // 처음 저장된 시각

    @LastModifiedDate
    private LocalDateTime modifyDate;              // 마지막 수정 시각
}