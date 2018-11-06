package ru.egor.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UsersPet")
public class UsersPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int up_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private PetAnimal petAnimal;

    public int getUp_id() {
        return up_id;
    }

    public void setUp_id(int up_id) {
        this.up_id = up_id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        if(petAnimal==null)return "no";
        else
        return "" + petAnimal;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PetAnimal getPetAnimal() {
        return petAnimal;
    }

    public void setPetAnimal(PetAnimal petAnimal) {
        this.petAnimal = petAnimal;
    }


}
