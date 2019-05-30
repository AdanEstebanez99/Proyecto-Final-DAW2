import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService implements CanActivate {

  constructor( private loginService: LoginService) { }

  canActivate(): boolean {
    if (this.loginService.getUsuarioLog().rol_usu === 1) {
      return true;
    } else {
      return false;
    }
  }

}
