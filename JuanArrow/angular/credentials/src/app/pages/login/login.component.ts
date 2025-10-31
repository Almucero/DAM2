import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators,
  FormGroup,
} from '@angular/forms';
import { LocalStorageAuthService } from '../../core/services/local-storage-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  formLogin: FormGroup;
  loginError = '';
  showPassword = false;
  registrationSuccess = false;
  readonly navigateTo: string = '';
  private router = inject(Router);

  constructor(
    private formSvc: FormBuilder,
    private auth: LocalStorageAuthService
  ) {
    this.formLogin = this.formSvc.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
    if (sessionStorage.getItem('registrationSuccess')) {
      this.registrationSuccess = true;
      sessionStorage.removeItem('registrationSuccess');
    }
    this.navigateTo =
      this.router.getCurrentNavigation()?.extras.state?.['navigateTo'] ||
      '/dashboard';
  }

  onSubmit() {
    this.loginError = '';
    if (this.formLogin.valid) {
      const success = this.auth.login(this.formLogin.value);
      if (success) {
        this.router.navigate([this.navigateTo]);
      } else {
        this.loginError = 'Usuario no registrado o credenciales incorrectas';
      }
    }
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }

  getError(control: string) {
    switch (control) {
      case 'email':
        if (
          this.formLogin.controls['email'].errors != null &&
          Object.keys(this.formLogin.controls['email'].errors).includes(
            'required'
          )
        )
          return 'El campo email es requerido';
        else if (
          this.formLogin.controls['email'].errors != null &&
          Object.keys(this.formLogin.controls['email'].errors).includes('email')
        )
          return 'El email no es correcto';
        break;
      case 'password':
        if (
          this.formLogin.controls['password'].errors != null &&
          Object.keys(this.formLogin.controls['password'].errors).includes(
            'required'
          )
        )
          return 'El campo contraseña es requerido';
        break;
      default:
        return '';
    }
    return '';
  }
}

//hacer loginError con signal
