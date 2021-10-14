package com.util.md.data.service.repository;

import com.util.md.data.entity.ArchivedTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivedTaskRepository extends JpaRepository<ArchivedTasks, Integer> {

}
