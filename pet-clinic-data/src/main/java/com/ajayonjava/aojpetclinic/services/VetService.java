package com.ajayonjava.aojpetclinic.services;

import com.ajayonjava.aojpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
