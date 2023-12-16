package in.springboot.Blog_Application.controller;

import in.springboot.Blog_Application.binding.LoginForm;
import in.springboot.Blog_Application.binding.PostForm;
import in.springboot.Blog_Application.entity.Post;
import in.springboot.Blog_Application.service.PostService;
import in.springboot.Blog_Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/addpost")
    public String handleAddPost(@ModelAttribute("addpost") PostForm form, Model model){
        boolean status = postService.addPost(form);
        if(status){
            model.addAttribute("succMsg", "Blog posted Successfully");
        }
        return "addblog";
    }

    @GetMapping("/addpost")
    public String addPost(Model model){
        model.addAttribute("addpost", new PostForm());
        return "addblog";
    }
}
