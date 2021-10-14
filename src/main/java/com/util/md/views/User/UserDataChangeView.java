package com.util.md.views.User;

import com.util.md.data.entity.Users;
import com.util.md.models.masterManager.UserRegistrationModel;
import com.util.md.security.AuthenticatedUser;
import com.util.md.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import java.sql.Date;
import java.util.Optional;

/**
 * A Designer generated component for the user-registration-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("user-registration-view")
@JsModule("./user/user-registration-view.ts")
@UIScope
@PermitAll
@SpringComponent
public class UserDataChangeView extends LitTemplate {

    @Id("prenume")
    private TextField prenume;
    @Id("parolă")
    private PasswordField parola;
    @Id("dataNasterii")
    private DatePicker dataNasterii;
    @Id("adresa")
    private TextField adresa;
    @Id("email")
    private EmailField email;
    @Id("nume")
    private TextField nume;
    @Id("vaadinButton")
    private Button vaadinButton;

    /**
     * Creates a new UserRegistrationView.
     */


    public UserDataChangeView(AuthenticatedUser authenticatedUser) {
        addClassName("main-view");
        vaadinButton.setText("Actualizeaza");
        // You can initialise any data required for the connected UI components here.
        Optional<Users> maybeUser = authenticatedUser.get();
        //maybeUser.
        if (maybeUser.isPresent()) {
            Users user = maybeUser.get();
        vaadinButton.addClickListener(
                event -> {

                        user.setName(nume.getValue());
                        user.setSurename(prenume.getValue());
                        user.setBirthDate(Date.valueOf(dataNasterii.getValue()));
                       // user.setAddress(adresa.getValue());
                        user.setEmail(email.getValue());
                        user.setPassword(parola.getValue());
                        //userRegistrationModel.setStatus(statut.getValue());

                        //user.saveUser();

                        //For debugging
                        Notification.show(nume.getValue() + prenume.getValue() + dataNasterii.getValue() + adresa.getValue() +
                                email.getValue() + parola.getValue() );



                        }
            );
        }

    }
}
