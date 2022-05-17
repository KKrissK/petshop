package epam.progkor.petshop.controller;

import epam.progkor.petshop.model.PetShop;
import epam.progkor.petshop.model.exception.NotFoundException;
import epam.progkor.petshop.service.PetShopService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet-shop")
public class PetShopController {

    private final PetShopService petShopService;

    public PetShopController(final PetShopService petShopService) {
        this.petShopService = petShopService;
    }

    @GetMapping
    public String getAllPet(final Model model) {
        final List<PetShop> petShops = petShopService.getAllPets();
        model.addAttribute( "petShops",petShops);
        return "petshop/list";
    }

    @GetMapping("/{id}")
    public String getPet(final Model model, final @PathVariable Long id ) {
        final PetShop petShop = petShopService.getPet(id);
        model.addAttribute( "petShop",petShop);
        return "petshop/edit";
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPetShop(final Model model,
                                final @RequestParam(value ="id", required = false) Long id,
                                final PetShop petShopChanges ) {
        final PetShop petShop = petShopService.updatePet(id,petShopChanges);
        model.addAttribute( "petShop",petShop);
        return "petshop/edit";

    }

    @GetMapping("/create")
    public String createPetShopForm(final Model model) {

        return "petshop/create";
    }

    @PostMapping("/create")
    public String createPetShop(final Model model,PetShop petShop) {
        final PetShop savedPetShop = petShopService.createPet(petShop);
        model.addAttribute( "petShop",savedPetShop);
        return "petshop/edit";
    }

    @GetMapping("/{id}/delete")
    public String deletePet(final Model model, @PathVariable("id") Long id) {
    try {
        petShopService.deletePet(id);
    } catch(NotFoundException e){
        //ignored
      }
        final List<PetShop> petShops = petShopService.getAllPets();
        model.addAttribute( "petShops",petShops);
        return "petshop/list";
    }

}
