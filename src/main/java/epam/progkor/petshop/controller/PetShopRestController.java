package epam.progkor.petshop.controller;

import epam.progkor.petshop.model.PetShop;
import epam.progkor.petshop.service.PetShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/pet-shop")
public class PetShopRestController {
    //CRUD

    private final PetShopService petShopService;

    public PetShopRestController(PetShopService petShopService) {
        this.petShopService = petShopService;
    }



    @GetMapping
    public List<PetShop> getAllPets() {
    return petShopService.getAllPets();
    }

    @GetMapping("/{id}")
    PetShop getPet(final @PathVariable("id") Long id) {
        return petShopService.getPet(id);
    }

    @PostMapping
    PetShop createPet(final @RequestBody  PetShop petShop) {
    return petShopService.createPet(petShop);
    }

    @PutMapping("/{id}")
    PetShop updatePet(final @PathVariable Long id,@RequestBody PetShop petShopChange ) {
        return petShopService.updatePet(id,petShopChange);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePet(final @PathVariable Long id) {
    petShopService.deletePet(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
