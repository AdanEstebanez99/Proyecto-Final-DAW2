import { Component, OnInit} from '@angular/core';
import { LoginService } from '../shared/login.service';
import { Usuario } from '../model/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  usuarioLog: Usuario;

  menu: string;
  modal: boolean;

  viewAdmin: boolean;

  constructor(private loginService: LoginService,
              private router: Router) {}


  ngOnInit() {

    this.modal = false;

    // COMPROBAMOS SI HAY ALGUN USUARIO CON SESION INICIADA
    this.usuarioLog = this.loginService.getUsuarioLog();

    if (this.usuarioLog != null) {
      if (this.usuarioLog.rol_usu === 1) {
        this.menu = 'admin';
      } else {
        this.menu = 'usuario';
      }

      this.viewAdmin = this.loginService.getViewAdmin();

    } else {
      this.menu = 'nolog';
    }

    console.log(this.menu);
  }

  // FUNCION PARA CONTROLAR MODAL DE CERRAR SESION
  modalCerrarSes() {
    this.modal = true;
  }

  // FUNCION PARA CERRAR SESION
  cerrarSesion() {
    this.loginService.setUsuarioLog(null);
    this.modal = false;
    this.router.navigate(['/']);
  }

  // FUNCION PARA CANCELAR EL CERRAR SESION
  cancelarCerrarSes() {
      this.modal = false;
  }

}
