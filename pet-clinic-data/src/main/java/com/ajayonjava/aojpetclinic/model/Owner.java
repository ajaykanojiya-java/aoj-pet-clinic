package com.ajayonjava.aojpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "OWNER")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "TELEPHONE")
    private String telephone;

    //below property will not be a column in OWNER table, however owner_id will be added in PET table as a foreign key
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //'owner' is the property in Pet class
    private Set<Pet> pets = new HashSet<>();
}
