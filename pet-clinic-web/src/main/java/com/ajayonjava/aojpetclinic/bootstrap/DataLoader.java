package com.ajayonjava.aojpetclinic.bootstrap;

import com.ajayonjava.aojpetclinic.model.Owner;
import com.ajayonjava.aojpetclinic.model.Pet;
import com.ajayonjava.aojpetclinic.model.PetType;
import com.ajayonjava.aojpetclinic.model.Vet;
import com.ajayonjava.aojpetclinic.services.OwnerService;
import com.ajayonjava.aojpetclinic.services.PetTypeService;
import com.ajayonjava.aojpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //@Autowired: no need to put @Autowired because we have defined parametrized constructor
    //so while creating object of this class spring will automatically inject the object dependency.
    //@Autowired can be used on member var of class but constructor is best practice.
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType =  petTypeService.save(cat);

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

        Vet vet2 = new Vet();
        vet2.setFirstName("Jassie");
        vet2.setLastName("Lamon");

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Vet data loaded....");
    }
}
