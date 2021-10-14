package com.util.md.data.service;

import com.util.md.data.entity.Services;
import com.util.md.data.service.repository.DataRepository;
import com.util.md.data.service.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudService;

public class ServiceService extends CrudService<Services, Integer> {

    private ServiceRepository repository;

    public ServiceService(@Autowired ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ServiceRepository getRepository() {
        return repository;
    }
}
