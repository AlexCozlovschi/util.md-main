package com.util.md.data.service;

import com.util.md.data.entity.Categories;
import com.util.md.data.service.repository.CategorieRepository;
import com.util.md.data.service.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudService;

public class CategorieService extends CrudService<Categories, Integer> {

    private CategorieRepository repository;

    public CategorieService(@Autowired CategorieRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CategorieRepository getRepository() {
        return repository;
    }
}
