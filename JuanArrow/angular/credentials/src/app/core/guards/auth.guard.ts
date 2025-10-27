import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { inject } from '@angular/core';

export const authGuard: CanActivateFn = (route, state) => {
  let auth = inject(AuthService);
  let router = inject(Router);
  let autheticated = auth.user.user()!=null;
  if (!autheticated) {
    router.navigate(["/login"])
  }
  return autheticated;
};
