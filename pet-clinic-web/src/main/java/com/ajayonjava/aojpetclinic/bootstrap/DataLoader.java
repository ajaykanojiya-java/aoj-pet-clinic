package com.ajayonjava.aojpetclinic.bootstrap;

import com.ajayonjava.aojpetclinic.model.*;
import com.ajayonjava.aojpetclinic.services.OwnerService;
import com.ajayonjava.aojpetclinic.services.PetTypeService;
import com.ajayonjava.aojpetclinic.services.SpecialtyService;
import com.ajayonjava.aojpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    //@Autowired: no need to put @Autowired because we have defined parametrized constructor
    //so while creating object of this class spring will automatically inject the object dependency.
    //@Autowired can be used on member var of class but constructor is best practice.
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData(){
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType =  petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("George");
        owner1.setLastName("Ramyond");
        owner1.setAddress("123 Test Street");
        owner1.setCity("South Carolina");
        owner1.setTelephone("1234567890");

        Pet owner1Pet = new Pet();
        owner1Pet.setName("Rosco");
        owner1Pet.setPetType(savedDogPetType);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setOwner(owner1);
        owner1.getPets().add(owner1Pet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rebbeca");
        owner2.setLastName("Davis");
        owner2.setAddress("231 Street");
        owner2.setCity("North Carolina");
        owner2.setTelephone("1259874635");

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Posco");
        owner2Pet.setPetType(savedCatPetType);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setOwner(owner2);

        owner2.getPets().add(owner2Pet);

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Owners data loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedDentistry);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jassie");
        vet2.setLastName("Lamon");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Vet data loaded....");
    }

}
