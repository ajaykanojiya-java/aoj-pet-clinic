package com.ajayonjava.aojpetclinic.repository;

import com.ajayonjava.aojpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
