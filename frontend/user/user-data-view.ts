import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-form-layout/vaadin-form-layout.js';

@customElement('user-data-view')
export class UserDataView extends LitElement {
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
<vaadin-form-layout style="width: 100%; height: 100%;">
 <vaadin-text-field label="Prenume" placeholder="Alexandru" id="prenume" required invalid style="align-self: flex-start; width: 100%;" readonly></vaadin-text-field>
 <vaadin-text-field label="Nume" placeholder="Cozlovschi" id="nume" required invalid style="align-self: flex-start;" readonly></vaadin-text-field>
 <vaadin-text-field label="Adresa" placeholder="Siretului 8" id="adresa" required invalid style="align-self: center;" readonly></vaadin-text-field>
 <vaadin-text-field label="Email" id="email" required invalid style="align-self: center;" readonly></vaadin-text-field>
</vaadin-form-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
