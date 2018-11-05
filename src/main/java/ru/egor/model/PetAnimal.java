package ru.egor.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PetAnimals")
public class PetAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pet_id;

    @Column(name = "petType")
    private String petType;

    @Column(name = "petName")
    private String petName;

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String toString() {
        return petType + " "  + petName;
    }
}
