package com.util.md.views.Categories;

import com.util.md.models.masterManager.Categories.AddCategoriesModel;
import com.util.md.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;


@Route(value ="categoriesView", layout = MainLayout.class)
@UIScope
@PermitAll
@SpringComponent
public class AddCategoriesView extends HorizontalLayout {

    @Autowired
    AddCategoriesModel addCategoriesModel;

    public AddCategoriesView(){
        addClassName("main-layout");

        TextField name = new TextField();
        name.setLabel("Nume");
        TextField desciption = new TextField();
        desciption.setLabel("Descriere");

        Button add_b = new Button( "Adaug[");

        add(name, desciption,add_b);

        add_b.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                    addCategoriesModel.setName(name.getValue());
                    addCategoriesModel.setDescription(desciption.getValue());
                    addCategoriesModel.saveCategory();
            }
        });
    }

}
