package com.util.md.data.service.repository;

import com.util.md.data.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categories, Integer> {
}
