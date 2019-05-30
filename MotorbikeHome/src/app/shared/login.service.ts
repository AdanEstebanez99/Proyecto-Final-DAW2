import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginService implements CanActivate {

  usuarioLog: Usuario;

  viewAdmin: boolean;

  // FUNCIONES PARA SABER QUE VISUALIZAR
  getViewAdmin() {
    return this.viewAdmin;
  }

  setViewAdmin(value) {
    this.viewAdmin = value;
  }

  // FUNCIONES PARA SABER LOS USUARIOS
  getUsuarioLog() {
    return this.usuarioLog;
  }

  setUsuarioLog(value) {
    this.usuarioLog = value;
  }



  canActivate(): boolean {
    if (this.usuarioLog && this.usuarioLog.rol_usu != null) {
      return true;
    } else {
      return false;
    }
  }

  constructor() { }
}
