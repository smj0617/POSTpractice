package com.back.domain.post.post.service;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor   // final 필드를 받는 생성자를 자동 생성 → 스프링이 PostRepository를 넣어 줌
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
     }

     public Optional<Post> findById(int id){
        return postRepository.findById(id);
     }

    public long count() {
        return postRepository.count();
    }

    public Post write(String title, String content) {
        return postRepository.save(new Post(title, content));
    }
}