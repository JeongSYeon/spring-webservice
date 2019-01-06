package me.yeonbot.webservice.web;

import lombok.AllArgsConstructor;
import me.yeonbot.webservice.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;


    @GetMapping("/") //  == @RequestMapping(value="/" , method= RequestMethod.GET)
    public String main(Model model) {

        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
