package in.springboot.Blog_Application.controller;

import in.springboot.Blog_Application.entity.Post;
import in.springboot.Blog_Application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String indexPage(Model model){
        List<Post> blogPosts = postService.allposts();
        System.out.println(blogPosts);
        model.addAttribute("blogPosts", blogPosts);
        return "index";
    }


}
