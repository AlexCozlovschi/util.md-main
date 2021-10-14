import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-text-field/src/vaadin-email-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-upload/src/vaadin-upload.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

@customElement('master-registration-view')
export class MasterRegistrationView extends LitElement {
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
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%;">
 <vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;">
  <vaadin-text-field label="Nume" placeholder="Turețchi" id="nume" required invalid></vaadin-text-field>
  <vaadin-text-field label="Prenume" placeholder="Gabriel" id="prenume" required invalid></vaadin-text-field>
  <vaadin-date-picker label="Data nașterii" placeholder="Pick a date" id="dataNașterii" required invalid></vaadin-date-picker>
  <vaadin-upload id="vaadinUpload">
    Documente 
  </vaadin-upload>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;">
  <vaadin-email-field id="email" label="Email" required placeholder="gabi@gmail.com" invalid></vaadin-email-field>
  <vaadin-password-field label="Parolă" placeholder="Enter password" value="secret1" id="parolă" required></vaadin-password-field>
  <vaadin-text-field label="Adresa" placeholder="Decebal 6/4" id="adresa" required invalid></vaadin-text-field>
  <vaadin-upload id="vaadinUpload1">
    Imaginea de profil 
  </vaadin-upload>
  <vaadin-button id="vaadinButton" style="flex-grow: 0; flex-shrink: 0; margin-top:30%; align-self: stretch;">
    Adaugă 
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%; flex-grow: 0;">
  <vaadin-combo-box label="Servicii prestate" id="serviciiPrestate"></vaadin-combo-box>
  <vaadin-combo-box id="statut" required label="Statut"></vaadin-combo-box>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
