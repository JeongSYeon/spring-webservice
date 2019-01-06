package me.yeonbot.webservice.web;

import lombok.AllArgsConstructor;
import me.yeonbot.webservice.domain.posts.PostsRepository;
import me.yeonbot.webservice.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor //lombok ) 생성자로 빈을 받을 수 있도록 해준다. @Autowired 없이 PostRepository에 빈주입
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
