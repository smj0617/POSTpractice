# POSTpractice

Spring Boot로 게시판의 **글·댓글 조회와 삭제** API를 한 단계씩 만들어 보는 실습입니다.

- 참고 강의: [slog 14172](https://www.slog.gg/p/14172/raw) 1부 (1~19강)
- 환경: Spring Boot `4.1.2`, Java `25`, Gradle (Kotlin DSL), H2

## 만들 API

모든 요청은 브라우저 주소창에서 확인할 수 있게 `GET` 방식으로 받습니다. 원래 삭제는 `GET`으로 하면 안 되지만, 실습 편의를 위해 이렇게 합니다.

| 메서드 | URL | 기능 |
|---|---|---|
| GET | `/api/v1/posts` | 글 다건조회 |
| GET | `/api/v1/posts/{id}` | 글 단건조회 |
| GET | `/api/v1/posts/{id}/delete` | 글 삭제 |
| GET | `/api/v1/posts/{postId}/comments` | 댓글 다건조회 |
| GET | `/api/v1/posts/{postId}/comments/{id}` | 댓글 단건조회 |
| GET | `/api/v1/posts/{postId}/comments/{id}/delete` | 댓글 삭제 |

## 범위 밖

- 존재하지 않는 id를 요청했을 때의 예외 처리 (스프링 기본 에러 페이지가 나옵니다)
- 글·댓글 작성, 수정

---

## 1단계: 프로젝트 세팅

### 추가된 것
- IntelliJ의 Spring Boot 마법사로 프로젝트를 생성했습니다.
- 의존성: Spring Web MVC, Lombok, Spring Boot DevTools
- 메인 클래스: `com.back.BackApplication`

### 동작 확인
- 요청: http://localhost:8080/
- 결과: **Whitelabel Error Page (404)**
  - 서버는 떠 있지만 `/` 주소를 처리할 코드가 아직 없어서 404가 나옵니다. 서버가 정상적으로 실행됐다는 뜻입니다.

![1단계 결과](docs/images/step1.png)
