package elementsoffashion.demo.controllers;

import elementsoffashion.demo.models.Jackets;
import elementsoffashion.demo.repositorites.JacketsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;



@Controller
public class JacketsController {
boolean inOutfit = true;
    @Resource
    private JacketsRepository jacketRepo;

    @RequestMapping("/all-jackets")
    public String showAllJackets(Model model,Model error) {
        if(inOutfit == false) {

            error.addAttribute("errorMessage","This item cannot be deleted because it is in an outfit");
            inOutfit = true;
        }
        model.addAttribute("jackets", jacketRepo.findAll());
        return "jacketsView";
    }

    @RequestMapping("/jackets/{id}")
    public String displaySingleJacket(@PathVariable long id, Model model) {
        Optional<Jackets> retrievedJacket = jacketRepo.findById(id);
        Jackets foundJacket = retrievedJacket.get();
        model.addAttribute("jacket", foundJacket);
        return "jacketView";
    }

    @RequestMapping("/removeJacket")
    public String removeJacket(){return "removeJacket";}

    @PostMapping("/deleteJacket/{id}")
    public String deleteJacket(@PathVariable Long id, Model model, Jackets jackets){

        try {

            jacketRepo.deleteById(id);
            model.addAttribute("jackets", jackets);
        }

        catch (Exception ex){
            inOutfit = false;

            return "redirect:/all-jackets";

        }
        return "redirect:/all-jackets";

    }

    @RequestMapping("/addJackets/submit")
    public String addJacketsSubmit(Jackets jackets, Model model) {
        jacketRepo.save(jackets);
        model.addAttribute("jackets",jackets);
        return "redirect:/all-jackets";
    }
}
