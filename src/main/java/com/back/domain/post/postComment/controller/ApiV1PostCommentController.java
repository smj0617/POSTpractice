package com.back.domain.post.postComment.controller;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import com.back.domain.post.postComment.dto.PostCommentDto;
import com.back.domain.post.postComment.entity.PostComment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts/{postId}/comments")   // 클래스 주소에도 {postId} 변수를 쓸 수 있음
@RequiredArgsConstructor
public class ApiV1PostCommentController {
    private final PostService postService;   // 댓글도 글을 통해 다루므로 PostService만 있으면 됨

    @GetMapping
    public List<PostCommentDto> getItems(
            @PathVariable int postId
    ) {
        Post post = postService.findById(postId).get();   // 1) 글을 먼저 찾고

        return post.getComments()                          // 2) 그 글의 댓글들을
                .stream()
                .map(PostCommentDto::new)                  // 3) DTO로 바꿔서 반환
                .toList();
    }

    @GetMapping("/{id}")
    public PostCommentDto getItem(
            @PathVariable int postId,
            @PathVariable int id
    ) {
        Post post = postService.findById(postId).get();          // 1) 글을 먼저 찾고
        PostComment postComment = post.findCommentById(id).get(); // 2) 그 글의 댓글 중에서 찾음

        return new PostCommentDto(postComment);
    }
}