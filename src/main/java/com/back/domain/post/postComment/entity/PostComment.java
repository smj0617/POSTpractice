package com.back.domain.post.postComment.entity;

import com.back.domain.post.post.entity.Post;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class PostComment extends BaseEntity {
    @ManyToOne(fetch = LAZY)   // 댓글 N개 : 글 1개. post_id 외래키 컬럼이 생김. LAZY = 실제로 쓸 때 조회
    private Post post;
    private String content;

    public PostComment(Post post, String content) {
        this.post = post;
        this.content = content;
    }
}