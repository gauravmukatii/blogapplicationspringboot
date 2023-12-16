package in.springboot.Blog_Application.binding;

import lombok.Data;

@Data
public class RegistrationForm {
    private String fname;
    private String lname;
    private String email;
    private String pwd;
}
