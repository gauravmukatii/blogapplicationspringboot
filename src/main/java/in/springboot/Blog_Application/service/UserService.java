package in.springboot.Blog_Application.service;


import in.springboot.Blog_Application.binding.LoginForm;
import in.springboot.Blog_Application.binding.RegistrationForm;

public interface UserService {

    public boolean registration(RegistrationForm form);
    public boolean login(LoginForm form);
}
