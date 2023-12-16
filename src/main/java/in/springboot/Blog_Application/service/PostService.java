package in.springboot.Blog_Application.service;

import in.springboot.Blog_Application.binding.PostForm;
import in.springboot.Blog_Application.entity.Post;

import java.util.List;

public interface PostService {

    public boolean addPost(PostForm form);

    public List<Post> allposts();
}
