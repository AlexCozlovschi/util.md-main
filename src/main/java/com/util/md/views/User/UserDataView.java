package com.util.md.views.User;

import com.util.md.data.entity.Addresses;
import com.util.md.data.entity.Data;
import com.util.md.data.entity.Users;
import com.util.md.security.AuthenticatedUser;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.security.PermitAll;
import java.util.Optional;

/**
 * A Designer generated component for the user-data-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("user-data-view")
@JsModule("./user/user-data-view.ts")
@UIScope
@PermitAll
@SpringComponent
public class UserDataView extends LitTemplate {

   // private Data data;

    @Id("email")
    private TextField email;
    @Id("nume")
    private TextField nume;
    @Id("prenume")
    private TextField prenume;
    @Id("adresa")
    private TextField adresa;



    /**
     * Creates a new UserDataView.
     */


    public UserDataView(AuthenticatedUser authenticatedUser) {
         addClassName("main-layout");
        Optional<Users> maybeUser = authenticatedUser.get();
        //maybeUser.
        if (maybeUser.isPresent()) {
            Users user = maybeUser.get();
            Data data = user.getDataByDataId();
            Addresses addresses = user.getAddressesByAddressId();


            email.setValue(user.getEmail());
            nume.setValue(user.getName());
            prenume.setValue(user.getSurename());
            adresa.setValue(addresses.getLocation());



        }

    }
}

