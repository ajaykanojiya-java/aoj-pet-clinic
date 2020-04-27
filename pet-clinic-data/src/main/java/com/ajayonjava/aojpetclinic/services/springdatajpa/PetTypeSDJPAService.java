package com.ajayonjava.aojpetclinic.services.springdatajpa;

import com.ajayonjava.aojpetclinic.model.PetType;
import com.ajayonjava.aojpetclinic.repository.PetTypeRepository;
import com.ajayonjava.aojpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJPAService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petType -> petTypes.add(petType));
        return petTypes;
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
