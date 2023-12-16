package in.springboot.Blog_Application.controller;

import in.springboot.Blog_Application.binding.LoginForm;
import in.springboot.Blog_Application.binding.RegistrationForm;
import in.springboot.Blog_Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String handleRegistration(@ModelAttribute("user") RegistrationForm form, Model model){

        boolean status = userService.registration(form);

        if(status == true){
            model.addAttribute("succMsg", "Registration Successful!!");
        }else{
            model.addAttribute("errMsg", "Email Id already Exist");
        }

        return "registration";
    }
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("userlogin") LoginForm form, Model model){
        boolean status = userService.login(form);

        if(status){
            model.addAttribute("succMsg", "Login Successful");
        }else{
            model.addAttribute("errMsg", "Invalid Credentials");
        }
        return "login";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userlogin", new LoginForm());
        return "login";
    }
}
