package me.yeonbot.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //@Before Annotation 은 테스트 전에 초기화 해야할 필드가 있을때 사용
    //@Before 사용하면 각 테스트가 서로 영향을 끼쳐 테스트 결과가 바뀌는 경우가 생기지 않는다.
    //@After 은 테스트 후
    //@Before, After 어노테이션을 사용한 메소드는 각각의 테스트마다 모두 실행 된다.
    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given:테스트 기반 환경을 구축하는 단계 ,
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("tjddus1109@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록() {
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시물")
                .content("테스트 본문")
                .author("tjddus1109@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getCreatedDate().isAfter(now));

    }
}