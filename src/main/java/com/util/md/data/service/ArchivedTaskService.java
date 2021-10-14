package com.util.md.data.service;

import com.util.md.data.entity.ArchivedTasks;
import com.util.md.data.service.repository.ArchivedTaskRepository;
import com.util.md.data.service.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudService;

public class ArchivedTaskService extends CrudService<ArchivedTasks, Integer> {

    private ArchivedTaskRepository repository;

    public ArchivedTaskService(@Autowired ArchivedTaskRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ArchivedTaskRepository getRepository() {
        return repository;
    }
}
