package com.ajayonjava.aojpetclinic.repository;

import com.ajayonjava.aojpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
