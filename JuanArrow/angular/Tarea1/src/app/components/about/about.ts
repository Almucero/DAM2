import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './about.html',
  styleUrl: './about.scss',
})
export class AboutComponent {
  imagen = 'https://cdn.zendalibros.com/wp-content/uploads/socrates.jpg';
  github = 'https://github.com/socrateslab';
  twitter = 'https://x.com/SocratesQuott';
  email = 'mailto:socrates@gmail.com';

  descripcion = `Soy Sócrates, un ciudadano de Atenas y un amante de la sabiduría. No pretendo saberlo todo; de hecho, 
  mi sabiduría consiste en reconocer mi propia ignorancia. Dedico mi vida a dialogar con quienes me rodean, cuestionando 
  sus creencias para ayudarlos a descubrir la verdad por sí mismos. Creo que una vida sin examen no merece ser vivida, y 
  que el mayor bien del hombre es cuidar su alma mediante la razón y la virtud.`;
}
