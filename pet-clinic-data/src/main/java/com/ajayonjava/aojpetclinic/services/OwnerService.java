package com.ajayonjava.aojpetclinic.services;

import com.ajayonjava.aojpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
