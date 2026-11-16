package com.back.domain.post.post.entity;

import com.back.domain.post.postComment.entity.PostComment;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;

@Entity                 // 이 클래스 = post 테이블
@Getter
@NoArgsConstructor      // JPA는 빈 생성자가 꼭 필요함
public class Post extends BaseEntity {
    private String title;
    private String content;

    // 글 1개 : 댓글 N개
    // mappedBy = "post" : 관계의 주인은 PostComment.post 필드(=외래키는 post_comment 테이블에 있음)
    // PERSIST : 글을 저장하면 리스트에 담긴 댓글도 같이 저장
    // REMOVE + orphanRemoval : 글을 지우거나 리스트에서 빼면 댓글도 DB에서 삭제
    @OneToMany(mappedBy = "post", cascade = {PERSIST, REMOVE}, orphanRemoval = true)
    private final List<PostComment> comments = new ArrayList<>();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 댓글은 반드시 글을 통해서만 만든다
    public PostComment addComment(String content) {
        PostComment postComment = new PostComment(this, content);
        comments.add(postComment);
        return postComment;
    }
    public Optional<PostComment> findCommentById(int id){
        return comments
                .stream()
                .filter(comment -> comment.getId() == id)
                .findFirst();
    }
}