import { Injectable, inject, signal } from '@angular/core';
import { Credentials } from '../models/credentials';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';

export interface LoginResponse {
  jwt: string;
  user: StrapiUser;
}

export interface StrapiUser {
  id: number;
  documentId: string;
}

@Injectable({
  providedIn: 'root',
})
export class StrapiAuthService {
  public user: any | null;
  public error: any | null;
  private token: string | null;

  private http: HttpClient = inject(HttpClient);

  constructor() {
    this.user = signal<any>(null);
    this.error = signal<any>(null);
    this.token = localStorage.getItem('token');
    this.me();
  }

  me(): User | null {
    this.http
      .get<StrapiUser>('http://localhost:1337/api/users/me', {
        headers: {
          Authorization: `Bearer ${this.token}`,
        },
      })
      .subscribe({
        next: (data) => {
          const user = {
            name: data.name,
            surname: data.surname,
            email: data.email,
          };
          this.setUser(user);
        },
        error: (err) => {},
      });
  }
  login(credentials: Credentials) {
    const body = {
      identifier: credentials.email,
      password: credentials.password,
    };
    this.http
      .post<LoginResponse>('http://localhost:1337/api/auth/local', body)
      .subscribe({
        next: (data) => {
          localStorage.setItem('token', data.jwt);
          const newUser: User = {
            email: data.user.email,
            name: data.user.name,
            surname: data.user.surname,
          };
          this.user.set(newUser);
        },
        error: (err) => {
          this.error.set(err);
        },
      });
  }

  setUser(user: User) {
    this.user.set(user);
  }
  logout() {
    this.user.set(null);
    this.user.error(null);
  }

  register() {}
}
