package elementsoffashion.demo.usermanagement;

import elementsoffashion.demo.models.Bottoms;
import elementsoffashion.demo.usermanagement.User;
import elementsoffashion.demo.usermanagement.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

public class UserController {

@Resource
UserRepository userRepo;


//    @RequestMapping("/addUser/submit")
//    public String addUser(User user, Model model){
//        userRepo.save(user);
//        model.addAttribute("user",user);
//        return "redirect:/outfit";
//    }
//
}
