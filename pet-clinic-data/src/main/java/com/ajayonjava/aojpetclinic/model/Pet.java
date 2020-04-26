package com.ajayonjava.aojpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PET")
public class Pet  extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")//'OWNER_ID will have a column in PET table
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")//'TYPE_ID' will have a column in PET table
    private PetType petType;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
