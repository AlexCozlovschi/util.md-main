package com.util.md.data.service;

import com.util.md.data.entity.Addresses;
import com.util.md.data.service.repository.AddressRepository;
import com.util.md.data.service.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudService;

public class AddressService extends CrudService<Addresses, Integer> {

    private AddressRepository repository;

    public AddressService(@Autowired AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    protected AddressRepository getRepository() {
        return repository;
    }
}
