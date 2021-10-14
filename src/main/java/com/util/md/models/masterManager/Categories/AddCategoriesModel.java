package com.util.md.models.masterManager.Categories;

import com.util.md.data.entity.Categories;
import com.util.md.data.service.repository.CategorieRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;



@SpringComponent
public class AddCategoriesModel {
    private String name;
    private String description;

    private Categories categories;

    @Autowired
    private CategorieRepository categorieRepository;

    public AddCategoriesModel(){}

    public void saveCategory(){
        categories = new Categories();

        categories.setName(name);
        categories.setDescription(description);

        categorieRepository.save(categories);



    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
