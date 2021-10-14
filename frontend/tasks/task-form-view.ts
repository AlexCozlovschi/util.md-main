import '@vaadin/vaadin-combo-box';
import '@vaadin/vaadin-icons';
import '@vaadin/vaadin-text-field/vaadin-email-field';
import { html, LitElement } from 'lit';
import { customElement } from 'lit/decorators';
import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field/vaadin-text-field';

@customElement('task-form-view')
export class TaskFormView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }

  render() {
    return html`
<main class="grid gap-xl items-start justify-center max-w-screen-md mx-auto pb-l px-l">
 <section class="flex flex-col flex-grow">
  <h2 class="mb-0 mt-xl text-3xl">Crează o comandă</h2>
  <p class="mb-xl mt-0 text-secondary">Câmpurile cu punctișor sunt obligatorii</p>
  <section class="flex flex-col mb-xl mt-m">
   <h3 class="mb-m mt-s text-2xl">Datele Persoanei</h3>
   <vaadin-text-field class="mb-s" label="Nume " pattern="[\\p{L} \\-]+" required id="nume"></vaadin-text-field>
   <vaadin-text-field class="mb-s" label="Prenume" pattern="[\\p{L} \\-]+" required id="prenume"></vaadin-text-field>
   <vaadin-email-field class="mb-s" label="Email" required id="email"></vaadin-email-field>
   <vaadin-text-field class="mb-s" label="Telefon" pattern="[\\d \\-\\+]+" required id="telefon"></vaadin-text-field>
  </section>
  <section class="flex flex-col mb-xl mt-m">
   <h3 class="mb-m mt-s text-2xl">Adresa</h3>
   <vaadin-combo-box class="mb-s" id="countrySelect" label="  Țara" required></vaadin-combo-box>
   <vaadin-text-field class="mb-s" label="Strada" pattern="[\\p{L} \\-]+" required id="str"></vaadin-text-field>
   <vaadin-text-field class="flex-grow mb-s" label="Orașul" required id="city"></vaadin-text-field>
  </section>
 </section>
 <section class="flex flex-col mb-xl mt-m">
  <h3 class="mb-m mt-s text-2xl">Serviciul</h3>
  <vaadin-combo-box class="mb-s" id="serviceSelect" label="  Serviciul" required></vaadin-combo-box>
  <vaadin-text-field class="mb-s" label="Prețul" pattern="[\\p{L} \\-]+" id="pret" readonly></vaadin-text-field>
 </section>
 <footer class="flex items-center justify-between my-m">
  <vaadin-button theme="tertiary-inline">
    Anulează 
  </vaadin-button>
  <vaadin-button theme="primary success">
    Plasează comanda 
  </vaadin-button>
 </footer>
</main>
`;
  }
}