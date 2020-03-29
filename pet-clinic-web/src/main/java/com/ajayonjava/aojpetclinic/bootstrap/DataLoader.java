package com.ajayonjava.aojpetclinic.bootstrap;

import com.ajayonjava.aojpetclinic.model.Owner;
import com.ajayonjava.aojpetclinic.model.Vet;
import com.ajayonjava.aojpetclinic.services.OwnerService;
import com.ajayonjava.aojpetclinic.services.VetService;
import com.ajayonjava.aojpetclinic.services.map.OwnerServiceMap;
import com.ajayonjava.aojpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("George");
        owner1.setLastName("Ramyond");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Rebbeca");
        owner2.setLastName("Davis");

        ownerService.save(owner1);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jassie");
        vet2.setLastName("Lamon");

        vetService.save(vet1);
        vetService.save(vet2);
    }
}
