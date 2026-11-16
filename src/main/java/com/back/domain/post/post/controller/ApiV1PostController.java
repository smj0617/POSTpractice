package com.back.domain.post.post.controller;

import com.back.domain.post.post.dto.PostDto;
import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class ApiV1PostController {
    private final PostService postService;

    @GetMapping
    public List<PostDto> getItems() {          // 반환 타입이 List<Post> → List<PostDto>로 바뀜
        List<Post> items = postService.findAll();

        return items
                .stream()                      // 리스트를 하나씩 흘려보내면서
                .map(PostDto::new)             // 각 Post를 new PostDto(post)로 변환
                .toList();                     // 다시 리스트로 모음
    }

    @GetMapping("/{id}")                       // GET /api/v1/posts/1, /api/v1/posts/2 …
    public PostDto getItem(
            @PathVariable int id               // 주소의 {id} 자리 값을 int로 받아옴
    ) {
        Post post = postService.findById(id).get();   // 없으면 예외 (이번 범위에선 처리 안 함)

        return new PostDto(post);
    }
}