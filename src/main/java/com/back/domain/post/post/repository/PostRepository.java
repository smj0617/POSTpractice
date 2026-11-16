package com.back.domain.post.post.repository;

import com.back.domain.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스만 선언하면 save, findById, findAll, delete, count 등을 스프링이 자동으로 구현해 줌
public interface PostRepository extends JpaRepository<Post, Integer> {
}