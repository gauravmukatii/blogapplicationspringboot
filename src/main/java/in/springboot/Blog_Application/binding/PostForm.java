package in.springboot.Blog_Application.binding;

import lombok.Data;

@Data
public class PostForm {

    private String title;
    private String description;
    private String content;
}
