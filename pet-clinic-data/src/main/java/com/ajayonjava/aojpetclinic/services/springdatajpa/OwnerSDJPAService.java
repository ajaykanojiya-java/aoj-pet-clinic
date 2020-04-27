package com.ajayonjava.aojpetclinic.services.springdatajpa;

import com.ajayonjava.aojpetclinic.model.Owner;
import com.ajayonjava.aojpetclinic.repository.OwnerRepository;
import com.ajayonjava.aojpetclinic.repository.PetRepository;
import com.ajayonjava.aojpetclinic.repository.PetTypeRepository;
import com.ajayonjava.aojpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
//Currently there are two implementation for OwnerService so spring will confuse to which implementation to call
//if there is no profile is active on configuration then the implementation without profile annotation will be called.
public class OwnerSDJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJPAService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner -> owners.add(owner));
        //ownerRepository.findAll().forEach(owners::add);   similar code to above
        return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
