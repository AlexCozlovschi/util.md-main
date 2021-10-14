package com.util.md.data.service.repository;

import com.util.md.data.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services, Integer> {
}
