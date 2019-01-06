package me.yeonbot.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

//보통 DAO 라고 불리는 DB Layer 접근자
//상속을 받으면 CRUD 메소드 자동 생성.
public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
