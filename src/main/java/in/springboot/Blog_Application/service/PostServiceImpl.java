package in.springboot.Blog_Application.service;

import in.springboot.Blog_Application.binding.PostForm;
import in.springboot.Blog_Application.entity.Post;
import in.springboot.Blog_Application.repo.PostRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.desktop.SystemEventListener;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private HttpSession session;


    @Override
    public boolean addPost(PostForm form) {

        Integer userId = (Integer) session.getAttribute("userId");
        Post post = new Post();
        post.getUser(userId);
        BeanUtils.copyProperties(form, post);

        postRepo.save(post);

        return true;
    }

    @Override
    public List<Post> allposts() {

        List<Post> blogPosts = postRepo.findAll();

        System.out.println(blogPosts);

        return blogPosts;
    }
}
