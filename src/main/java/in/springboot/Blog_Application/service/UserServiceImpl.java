package in.springboot.Blog_Application.service;

import in.springboot.Blog_Application.binding.LoginForm;
import in.springboot.Blog_Application.binding.RegistrationForm;
import in.springboot.Blog_Application.entity.User;
import in.springboot.Blog_Application.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;
    @Override
    public boolean registration(RegistrationForm form) {

        User user = userRepo.findByEmail(form.getEmail());

        if(user != null){
            return false;
        }

        System.out.println(form);

        User newUser = new User();
        BeanUtils.copyProperties(form, newUser);

        System.out.println(newUser);

        userRepo.save(newUser);

        return true;
    }

    @Override
    public boolean login(LoginForm form) {

        User user = userRepo.findByEmailAndPwd(form.getEmail(), form.getPwd());

        if(user == null){
            return false;
        }

        return true;
    }
}
