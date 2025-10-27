import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  formLogin;

  //, Validators.pattern('((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,30})')
  constructor(private formsSvc: FormBuilder, private auth: AuthService) {
    this.formLogin = this.formsSvc.group({
      email: ['', (Validators.required, Validators.email)],
      password: ['', Validators.required],
    });
  }

  onSubmit() {
    console.log(this.formLogin.value);
    this.auth.login(this.formLogin.value as any);
  }

  getError(control: string) {
    switch (control) {
      case 'email':
        if (
          this.formLogin.controls.email.errors != null &&
          Object.keys(this.formLogin.controls.email.errors).includes('required')
        )
          return 'El campo email es requerido';
        else if (
          this.formLogin.controls.email.errors != null &&
          Object.keys(this.formLogin.controls.email.errors).includes('email')
        )
          return 'El email no es correcto';
      case 'password':
        if (
          this.formLogin.controls.password.errors != null &&
          Object.keys(this.formLogin.controls.password.errors).includes(
            'required'
          )
        )
          return 'El campo email es requerido';
        else if (
          this.formLogin.controls.password.errors != null &&
          Object.keys(this.formLogin.controls.password.errors).includes(
            'password'
          )
        )
          return 'El email no es correcto';
      default:
        return '';
    }
    return '';
  }
}
//cokie usuarios - array
//metodo register