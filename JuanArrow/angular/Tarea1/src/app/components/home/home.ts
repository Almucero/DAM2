import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class HomeComponent {
  nombreInput: string = '';
  nombres: string[] = [];

  agregarNombre() {
    if (this.nombreInput.trim() !== '') {
      this.nombres.push(this.nombreInput);
      this.nombreInput = '';
    }
  }

  borrarNombre(index: number) {
    this.nombres.splice(index, 1);
  }
}
