package epam.progkor.petshop.model;

import java.util.Objects;

public class PetShop {

    private Long id;
    private String name;
    private AnimalType animalType;
    private HardnessLevel hardnessLevel;


    public PetShop() {

    }

    public PetShop(Long id, String name, AnimalType animalType, HardnessLevel hardnessLevel) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
        this.hardnessLevel = hardnessLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public HardnessLevel getHardnessLevel() {
        return hardnessLevel;
    }

    public void setHardnessLevel(HardnessLevel hardnessLevel) {
        this.hardnessLevel = hardnessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetShop petShop = (PetShop) o;
        return Objects.equals(id, petShop.id) && Objects.equals(name, petShop.name) && animalType == petShop.animalType && hardnessLevel == petShop.hardnessLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, animalType, hardnessLevel);
    }

    @Override
    public String toString() {
        return "PetShop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalType=" + animalType +
                ", hardnessLevel=" + hardnessLevel +
                '}';
    }


}
