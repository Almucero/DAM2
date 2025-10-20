import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-hijo',
  imports: [],
  templateUrl: './hijo.component.html',
  template: `<p>Usuario: {{ nombre }}</p>`,
  styleUrl: './hijo.component.scss'
})
export class HijoComponent {
  @Input() nombre: string = '';
}
