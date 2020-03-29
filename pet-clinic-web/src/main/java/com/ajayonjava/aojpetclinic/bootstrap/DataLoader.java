package com.ajayonjava.aojpetclinic.bootstrap;

import com.ajayonjava.aojpetclinic.model.Owner;
import com.ajayonjava.aojpetclinic.model.Vet;
import com.ajayonjava.aojpetclinic.services.OwnerService;
import com.ajayonjava.aojpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    //@Autowired: no need to put @Autowired because we have defined parametrized constructor
    //so while creating object of this class spring will automatically inject the object dependency.
    //@Autowired can be used on member var of class but constructor is best practice.
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("George");
        owner1.setLastName("Ramyond");

        Owner owner2 = new Owner();
        owner2.setFirstName("Rebbeca");
        owner2.setLastName("Davis");

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
