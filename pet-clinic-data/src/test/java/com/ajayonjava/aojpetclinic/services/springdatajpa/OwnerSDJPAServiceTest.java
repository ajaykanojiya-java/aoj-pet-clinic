package com.ajayonjava.aojpetclinic.services.springdatajpa;

import com.ajayonjava.aojpetclinic.model.Owner;
import com.ajayonjava.aojpetclinic.repository.OwnerRepository;
import com.ajayonjava.aojpetclinic.repository.PetRepository;
import com.ajayonjava.aojpetclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
class OwnerSDJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJPAService ownerSDJPAService;

    private static final String LAST_NAME = "Smith";
    private static final String FIRST_NAME = "John";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).firstName(FIRST_NAME).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(returnOwner);
        Owner owner = ownerSDJPAService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,owner.getLastName());
        verify(ownerRepository,times(1)).findByLastName(anyString());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJPAService.findById(1L);
        assertNotNull(owner);
        verify(ownerRepository,times(1)).findById(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner owner = ownerSDJPAService.save(returnOwner);
        assertNotNull(owner);
        verify(ownerRepository,times(1)).save(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> ownersSet = ownerSDJPAService.findAll();
        assertEquals(2,ownersSet.size());
        verify(ownerRepository,times(1)).findAll();
    }

    @Test
    void delete() {
        ownerSDJPAService.delete(returnOwner);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJPAService.deleteById(1L);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}