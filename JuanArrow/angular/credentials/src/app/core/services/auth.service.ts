import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly _user: any = {
    name: "este",
    surnmae: "de aqui",
    email: "este@gmail.es"
  }
  public user: any | null;

  constructor() { 
    this.user = signal<any>(null)
    let cookie = localStorage.getItem("AUTHENTICATION");
    if (cookie) {
      this.user.set(this._user)
    }
  }

  login(credentials: Credential) {
    localStorage.setItem("AUTHENTICATION", JSON.stringify(credentials));
    this.user.set(this._user)
  }
  
  logout() {
    localStorage.removeItem("AUTHENTICATION");
    this.user.set(null);
  }
}
