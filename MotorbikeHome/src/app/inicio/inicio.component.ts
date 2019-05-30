import { Component, OnInit } from '@angular/core';
import { ApiService } from '../shared/api.service';
import { Md5 } from 'ts-md5/dist/md5';
import { LoginService } from '../shared/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss'],
  providers: [Md5]
})
export class InicioComponent {

  modal: boolean;

  usuario: string;
  contrasena: string;

  constructor(private apiService: ApiService,
              private loginService: LoginService,
              private router: Router,
              private md5: Md5) { }

  // FUNCION PARA LOGUEAR UN USUARIO
  public getUsuLog() {

    const md5 = new Md5();

    let password: string | Int32Array;
    password = md5.appendStr(this.contrasena).end();

    this.contrasena = password.toString();

    this.apiService.getInicioUsuario(this.usuario, this.contrasena).subscribe(
      res => {

        // COMPROBAMOS SI LA RESPUESTA ESTA VACIA (INICIO INCORRECTO)
        // O SI LA RESPUESTA VIENE CON DATOS (INICIO DE SESION CORRECTO)
        if (res != null) {
          console.log('Inicio de sesion CORRECTO');
          this.loginService.setUsuarioLog(res);
          this.router.navigate(['/contenido']);
        } else {
          console.log('Inicio de sesion INCORRECTO');
          this.contrasena = '';
          this.modal = true;
        }

      },
      err => {
        alert('Error al conectar con la API');
      }
    );

  }


  ocultarModal() {
    if (this.modal === true) {
      this.modal = false;
    } else {
      this.modal = false;
    }
  }

}
