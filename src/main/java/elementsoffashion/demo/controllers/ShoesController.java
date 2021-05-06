package elementsoffashion.demo.controllers;

import elementsoffashion.demo.models.Shoes;
import elementsoffashion.demo.repositorites.ShoesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class ShoesController {
boolean inOutfit = true;
    @Resource
    private ShoesRepository shoeRepo;

    @RequestMapping("/all-shoes")
    public String displayAllShoes(Model model, Model error) {
        if(inOutfit == false) {

            error.addAttribute("errorMessage","This item cannot be deleted because it is in an outfit");
            inOutfit = true;
        }
        model.addAttribute("shoes", shoeRepo.findAll());
        return "shoesView";
    }

    @RequestMapping("/shoes/{id}")
    public String displaySingleShoe(@PathVariable long id, Model model) {
        Optional<Shoes> retrievedShoes = shoeRepo.findById(id);
        Shoes foundShoes = retrievedShoes.get();
        model.addAttribute("shoe", foundShoes);
        return "shoeView";
    }

    @RequestMapping("/removeShoes")
    public String removeShoes() {
        return "removeShoes";
    }

    @PostMapping("/deleteShoes/{id}")
    public String deleteShoes(@PathVariable Long id, Model model, Shoes shoes) {
        try{
            shoeRepo.deleteById(id);
            model.addAttribute("shoes", shoes);

        }

        catch (Exception ex) {
            inOutfit = false;

            return "redirect:/all-shoes";
        }
        return "redirect:/all-shoes";
    }

    @RequestMapping("/addShoes/submit")
    public String addShoesSubmit(Shoes shoes, Model model) {
        shoeRepo.save(shoes);
        model.addAttribute("shoes", shoes);
        return "redirect:/all-shoes";
    }

}

