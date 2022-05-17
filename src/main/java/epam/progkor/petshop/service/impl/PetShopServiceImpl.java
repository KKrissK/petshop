package epam.progkor.petshop.service.impl;

import epam.progkor.petshop.model.AnimalType;
import epam.progkor.petshop.model.HardnessLevel;
import epam.progkor.petshop.model.PetShop;
import epam.progkor.petshop.model.exception.NotFoundException;
import epam.progkor.petshop.service.PetShopService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PetShopServiceImpl implements PetShopService {

    private static final List<PetShop> DATA_BASE = new ArrayList<>();

    static {

        DATA_BASE.add(new PetShop(1L,"Teknos", AnimalType.REPTILE, HardnessLevel.MEDIUM));
        DATA_BASE.add(new PetShop(2L,"Papagaj", AnimalType.BIRD, HardnessLevel.MEDIUM));
        DATA_BASE.add(new PetShop(2L,"Goldfish ", AnimalType.FISH, HardnessLevel.LOW));
    }

    @Override
    public List<PetShop> getAllPets() {
        return Collections.unmodifiableList(DATA_BASE);
    }

    @Override
    public PetShop getPet(final Long id) {
        return DATA_BASE.stream()
                .filter(petShop -> petShop.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public PetShop createPet(final PetShop petShop) {
       petShop.setId(getNextId());
       DATA_BASE.add(petShop);
       return petShop;
    }

    @Override
    public PetShop updatePet(final Long id, final PetShop petShopChange) {
        final PetShop petShop = getPet(id);
        petShop.setName(petShopChange.getName());
        petShop.setAnimalType(petShopChange.getAnimalType());
        petShop.setHardnessLevel(petShopChange.getHardnessLevel());
        return petShop;
    }

    @Override
    public void deletePet(final Long id) {
        final PetShop petshop = getPet(id);
        DATA_BASE.remove(petshop);
    }

    private long getLastId() {
       return DATA_BASE.stream().mapToLong(PetShop::getId)
                .max()
                .orElse(0);

    }

    private long getNextId() {
       return getLastId()+1L;
    }
}
