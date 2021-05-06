package elementsoffashion.demo.controllers;

import elementsoffashion.demo.models.Tops;
import elementsoffashion.demo.repositorites.TopsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class TopsController {

    boolean inOutfit = true;

    @Resource
    private TopsRepository topsRepo;

    @RequestMapping("/all-tops")
    public String displayAllTops(Model model, Model error) {
        if(inOutfit == false) {
            error.addAttribute("errorMessage","This item cannot be deleted because it is in an outfit");
            inOutfit = true;
        }
        model.addAttribute("tops", topsRepo.findAll());
        return "topsView";
    }

    @RequestMapping("/tops/{id}")
    public String displaySingleTop(@PathVariable long id, Model model) {
        Optional<Tops> retrievedTop = topsRepo.findById(id);
        Tops foundTop = retrievedTop.get();
        model.addAttribute("top", foundTop);
        return "topView";
    }

    @RequestMapping("/removeTops")
    public String removeTops() {
        return "removeTops";
    }

    @PostMapping("/deleteTops/{id}")
    public String removeTops(@PathVariable Long id, Model model, Tops tops) {
        try {

            topsRepo.deleteById(id);
            model.addAttribute("tops", tops);
        } catch (Exception ex) {

            inOutfit = false;


            return "redirect:/all-tops";

        }

        return "redirect:/all-tops";
    }

    @RequestMapping("/addTops/submit")
    public String addTopsSubmit(Tops tops, Model model) {
        topsRepo.save(tops);
        model.addAttribute("tops", tops);
        return "redirect:/all-tops";
    }
}
