package com.util.md.data.service;

import com.util.md.data.entity.Tasks;
import com.util.md.data.service.repository.DataRepository;
import com.util.md.data.service.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudService;

public class TaskService extends CrudService<Tasks, Integer> {

    private TaskRepository repository;

    public TaskService(@Autowired TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    protected TaskRepository getRepository() {
        return repository;
    }
}
