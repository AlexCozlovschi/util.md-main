package com.util.md.data.service.repository;


import com.util.md.data.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.artur.helpers.CrudService;

public interface DataRepository extends JpaRepository<Data, Integer> {

}
