package elementsoffashion.demo.controllers;

import elementsoffashion.demo.usermanagement.User;
import elementsoffashion.demo.usermanagement.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserRegistrationController {





    @Resource
    private UserRepository userRepo;

    @RequestMapping("/user-registration")
    public String displayForm(){
        return "user-registration";
    }

    @RequestMapping("/addUser/submit")
    public String addUser(User user){

        return "login";

    }



}

