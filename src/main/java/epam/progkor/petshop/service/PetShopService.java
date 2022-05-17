package epam.progkor.petshop.service;
import java.util.List;
import epam.progkor.petshop.model.PetShop;

public interface PetShopService {

    List<PetShop> getAllPets();

    PetShop getPet(Long id);

    PetShop createPet(PetShop petShop);

    PetShop updatePet(Long id,PetShop petShopChange );

    void deletePet(Long id);

}
