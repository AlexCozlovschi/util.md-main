package com.util.md.views.Tasks;

import com.util.md.data.entity.Addresses;
import com.util.md.data.entity.Users;
import com.util.md.security.AuthenticatedUser;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.security.PermitAll;


/**
 * A Designer generated component for the task-form-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */


@Tag("task-form-view")
@JsModule("./tasks/task-form-view.ts")

@UIScope
@PermitAll
@SpringComponent
public class TaskFormView  extends LitTemplate implements HasStyle {

    @Id("nume")
    private TextField nume;
    @Id("prenume")
    private TextField prenume;
    @Id("email")
    private EmailField email;
    @Id("telefon")
    private TextField telefon;
    @Id("countrySelect")
    private ComboBox<String> countrySelect;
    @Id("str")
    private TextField str;
    @Id("city")
    private TextField city;
    @Id("serviceSelect")
    private ComboBox<String> serviceSelect;
    @Id("pret")
    private TextField pret;

    /**
     * Creates a new TaskFormView.
     */
    public TaskFormView(AuthenticatedUser authenticatedUser) {
        Optional<Users> maybeUser = authenticatedUser.get();
        //maybeUser.
        if (maybeUser.isPresent()) {
            Users user = maybeUser.get();
            Addresses addresses = user.getAddressesByAddressId();
            nume.setValue(user.getName());
            prenume.setValue(user.getSurename());
            email.setValue(user.getEmail());
            str.setValue(addresses.getLocation());

        }
        // You can initialise any data required for the connected UI components here.
    }

}
