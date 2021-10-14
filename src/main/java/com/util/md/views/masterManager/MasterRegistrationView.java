package com.util.md.views.masterManager;

import com.util.md.models.masterManager.MasterRegistrationModel;
import com.util.md.security.AuthenticatedUser;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import elemental.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * A Designer generated component for the master-registration-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("master-registration-view")
@JsModule("./themes/util.md/designer_views/master-registration-view.ts")
@UIScope
@SpringComponent
@EnableAutoConfiguration
public class MasterRegistrationView extends LitTemplate {

    @Id("nume")
	private TextField nume;
	@Id("prenume")
	private TextField prenume;
	@Id("dataNașterii")
	private DatePicker dataNasterii;
	@Id("vaadinUpload")
	private Upload vaadinUpload;
	@Id("email")
	private EmailField email;
	@Id("parolă")
	private PasswordField parola;
	@Id("statut")
	private ComboBox<String> statut;
	@Id("vaadinUpload1")
	private Upload vaadinUpload1;
	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("serviciiPrestate")
	private ComboBox<String> serviciiPrestate;
	@Id("adresa")
	private TextField adresa;
	public MultiFileMemoryBuffer filebuffer;
	public MemoryBuffer picbuffer;
	/**
     * Creates a new MasterRegistrationView.
     */
    public MasterRegistrationView(@Autowired MasterRegistrationModel masterRegistrationModel) {
		addClassName("main-view");

		setBuffers();
		statut.setItems("UNVERIFIED","VERIFIED","BLOCKED");

		//Upload listeners
		vaadinUpload.addSucceededListener(
				event -> {
					masterRegistrationModel.uploadFiles(filebuffer.getInputStream(event.getFileName()), event.getFileName());
				}
		);
		vaadinUpload1.addSucceededListener(
				event -> {
					masterRegistrationModel.uploadPicture(picbuffer.getInputStream(), event.getFileName());
				}
		);

		//Upload button listener
		vaadinButton.addClickListener(
			event -> {

				if(!masterRegistrationModel.mailExists(email.getValue())){

					masterRegistrationModel.setName(nume.getValue());
					masterRegistrationModel.setSurename(prenume.getValue());
					masterRegistrationModel.setBirthDate(dataNasterii.getValue());
					masterRegistrationModel.setAddress(adresa.getValue());
					masterRegistrationModel.setEmail(email.getValue());
					masterRegistrationModel.setPassword(parola.getValue());
					masterRegistrationModel.setStatus(statut.getValue());

					masterRegistrationModel.saveMaster();

					//For debugging
					Notification.show(nume.getValue() + prenume.getValue() + dataNasterii.getValue() + adresa.getValue() +
							email.getValue() + parola.getValue() + statut.getValue());

				} else {
					Notification.show("Email-ul deja există!");
				}

			}
		);


    }

	public void setBuffers(){
		filebuffer = new MultiFileMemoryBuffer();
		picbuffer = new MemoryBuffer();
		vaadinUpload.setReceiver(filebuffer);
		vaadinUpload1.setReceiver(picbuffer);
	}

}
