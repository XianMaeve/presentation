package elementsoffashion.demo.controllers;

import elementsoffashion.demo.models.Bottoms;
import elementsoffashion.demo.repositorites.BottomsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class BottomsController {
    boolean inOutfit = true;

    @Resource
    private BottomsRepository bottomsRepo;

    @RequestMapping("/all-bottoms")
    public String displayAllBottoms(Model model,Model error){
        if(inOutfit == false){

            error.addAttribute("errorMessage","This item cannot be deleted because it is in an outfit");
            inOutfit = true;
        }
        model.addAttribute("bottoms",bottomsRepo.findAll());
        return "bottomsView";
    }
    @RequestMapping("/bottoms/{id}")
    public String displaySingleBottom(@PathVariable long id, Model model){
        Optional<Bottoms> retrievedBottom = bottomsRepo.findById(id);
        Bottoms foundBottom = retrievedBottom.get();
        model.addAttribute("bottom", foundBottom);
        return "bottomView";
    }
    @RequestMapping("/removeBottoms")
    public String removeBottoms() {return "removeBottoms";}

    @PostMapping("/deleteBottoms/{id}")
    public String removeBottom(@PathVariable Long id, Model model, Bottoms bottoms) {

        try {

            bottomsRepo.deleteById(id);
            model.addAttribute("bottoms",bottoms);
        }

        catch (Exception ex) {
            inOutfit = false;

            return "redirect:/all-bottoms";
        }
        return "redirect:/all-bottoms";
    }

    @RequestMapping("addBottoms/submit")
    public String addBottoms(Bottoms bottoms, Model model){
        bottomsRepo.save(bottoms);
        model.addAttribute("bottoms",bottoms);
        return "redirect:/all-bottoms";
    }


}
