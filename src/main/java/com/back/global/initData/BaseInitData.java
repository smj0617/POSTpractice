package com.back.global.initData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    @Autowired
    @Lazy
    private BaseInitData self;          // 자기 자신의 "프록시"를 주입받음 (아래 설명 참고)
    private final PostService postService;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> self.work1();    // 앱 시작이 끝나면 자동으로 1번 실행됨
    }

    @Transactional                      // 이 메서드 전체가 하나의 트랜잭션
    public void work1() {
        if (postService.count() > 0) return;   // 이미 데이터가 있으면 다시 만들지 않음

        Post post1 = postService.write("제목 1", "내용 1");
        Post post2 = postService.write("제목 2", "내용 2");
        postService.write("제목 3", "내용 3");

        post1.addComment("댓글 1-1");    // save를 따로 안 불러도
        post1.addComment("댓글 1-2");    // 트랜잭션이 끝날 때 JPA가 변화를 감지해서(더티체킹)
        post1.addComment("댓글 1-3");    // cascade PERSIST로 댓글을 INSERT 함
        post2.addComment("댓글 2-1");
        post2.addComment("댓글 2-2");
    }
}