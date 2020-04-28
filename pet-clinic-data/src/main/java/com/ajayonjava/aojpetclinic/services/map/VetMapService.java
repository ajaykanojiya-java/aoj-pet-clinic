package com.ajayonjava.aojpetclinic.services.map;

import com.ajayonjava.aojpetclinic.model.Specialty;
import com.ajayonjava.aojpetclinic.model.Vet;
import com.ajayonjava.aojpetclinic.services.SpecialtyService;
import com.ajayonjava.aojpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service //This is an indication that this class is spring managed bean and will be initialized while startup
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {
    private SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialties() != null){
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
