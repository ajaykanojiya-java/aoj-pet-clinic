package com.ajayonjava.aojpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
