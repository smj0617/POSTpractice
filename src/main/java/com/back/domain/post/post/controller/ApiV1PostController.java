package com.back.domain.post.post.controller;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                    // 이 클래스의 메서드 반환값을 HTML이 아니라 JSON으로 응답
@RequestMapping("/api/v1/posts")   // 이 컨트롤러의 모든 주소 앞에 /api/v1/posts가 붙음
@RequiredArgsConstructor
public class ApiV1PostController {
    private final PostService postService;

    @GetMapping                    // GET /api/v1/posts
    public List<Post> getItems() {
        return postService.findAll();   // 엔티티 리스트를 그대로 반환 → Jackson이 JSON으로 변환
    }
}