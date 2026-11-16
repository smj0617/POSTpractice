package com.back.domain.post.post.dto;

import com.back.domain.post.post.entity.Post;

import java.time.LocalDateTime;

// record = 값을 담기만 하는 불변 객체.
// 생성자, getter(id(), title()…), equals, toString을 자바가 자동으로 만들어 줌
public record PostDto(
        int id,
        LocalDateTime createDate,
        LocalDateTime modifyDate,
        String title,
        String content
) {
    // 엔티티 → DTO 변환용 생성자. Post를 받아서 필요한 값만 골라 담음
    public PostDto(Post post) {
        this(
                post.getId(),
                post.getCreateDate(),
                post.getModifyDate(),
                post.getTitle(),
                post.getContent()
        );
    }
}