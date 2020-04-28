package com.ajayonjava.aojpetclinic.services.map;

import com.ajayonjava.aojpetclinic.model.Pet;
import com.ajayonjava.aojpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service //This is an indication that this class is spring managed bean and will be initialized while startup
@Profile({"default","map"})
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
}
