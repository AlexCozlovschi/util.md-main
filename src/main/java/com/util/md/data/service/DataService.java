package com.util.md.data.service;

import com.util.md.data.entity.Data;
import com.util.md.data.service.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.artur.helpers.CrudService;

public class DataService extends CrudService<Data, Integer> {

    private DataRepository repository;

    public DataService(@Autowired DataRepository repository) {
        this.repository = repository;
    }

    @Override
    protected DataRepository getRepository() {
        return repository;
    }
}
