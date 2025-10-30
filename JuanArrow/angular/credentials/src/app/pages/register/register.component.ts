import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  formRegister: FormGroup;
  registrationError = '';
  showPassword = false;
  private router = inject(Router);

  constructor(private formSvc: FormBuilder, private auth: AuthService) {
    this.formRegister = this.formSvc.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/),
        ],
      ],
    });
  }

  onSubmit() {
    if (this.formRegister.valid) {
      const success = this.auth.register(this.formRegister.value);
      if (success) {
        sessionStorage.setItem('registrationSuccess', 'true');
        this.router.navigate(['/login']);
      } else {
        this.registrationError = 'El email ya está registrado';
      }
    }
  }

  goBack() {
    this.router.navigate(['/login']);
  }

  getError(control: string): string {
    switch (control) {
      case 'email':
        if (
          this.formRegister.controls['email'].errors != null &&
          Object.keys(this.formRegister.controls['email'].errors).includes(
            'required'
          )
        )
          return 'El campo email es requerido';
        else if (
          this.formRegister.controls['email'].errors != null &&
          Object.keys(this.formRegister.controls['email'].errors).includes(
            'email'
          )
        )
          return 'El email no es correcto';
        break;
      case 'password':
        if (
          this.formRegister.controls['password'].errors != null &&
          Object.keys(this.formRegister.controls['password'].errors).includes(
            'required'
          )
        )
          return 'El campo contraseña es requerido';
        else if (
          this.formRegister.controls['password'].errors != null &&
          Object.keys(this.formRegister.controls['password'].errors).includes(
            'pattern'
          )
        )
          return 'La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número';
        break;
      case 'name':
        if (
          this.formRegister.controls['name'].errors != null &&
          Object.keys(this.formRegister.controls['name'].errors).includes(
            'required'
          )
        )
          return 'El nombre es requerido';
        break;
      case 'surname':
        if (
          this.formRegister.controls['surname'].errors != null &&
          Object.keys(this.formRegister.controls['surname'].errors).includes(
            'required'
          )
        )
          return 'El apellido es requerido';
        break;
    }
    return '';
  }
}
