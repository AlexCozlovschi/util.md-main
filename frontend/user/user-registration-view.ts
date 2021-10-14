import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-email-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';

@customElement('user-registration-view')
export class UserRegistrationView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;">
 <vaadin-form-layout style="align-self: center;">
  <vaadin-text-field label="Prenume" placeholder="Alexandru" id="prenume" required invalid style="align-self: flex-start; width: 100%;"></vaadin-text-field>
  <vaadin-text-field label="Nume" placeholder="Cozlovschi" id="nume" required invalid style="align-self: flex-start;"></vaadin-text-field>
  <vaadin-text-field label="Adresa" placeholder="Siretului 8" id="adresa" required invalid style="align-self: center;"></vaadin-text-field>
  <vaadin-email-field label="Email" required placeholder="example@gmail.com" id="email" invalid></vaadin-email-field>
  <vaadin-password-field label="Password" placeholder="Enter password" value="secret1" style="align-self: flex-start;" required id="parolă"></vaadin-password-field>
  <vaadin-date-picker label="Birthday" placeholder="Pick a date" id="dataNasterii"></vaadin-date-picker>
 </vaadin-form-layout>
 <vaadin-button id="vaadinButton" style="flex-grow: 0; flex-shrink: 1; align-self: center;">
   Înregistrează 
 </vaadin-button>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
