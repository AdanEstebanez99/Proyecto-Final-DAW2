import { Component, OnInit } from '@angular/core';
import { Md5 } from 'ts-md5/dist/md5';
import { ApiService } from '../shared/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss'],
  providers: [Md5]
})
export class RegistroComponent implements OnInit {

  modal: boolean;

  modalCorrecto: boolean;

  contrasena: string;

  model: RegistroViewModel = {
    nick_usu: '',
    nom_usu: '',
    ape_usu: '',
    con_usu: '',
    cor_usu: '',
    col_usu: '',
  };

  constructor(private apiService: ApiService,
              private md5: Md5,
              private router: Router) {
  }

  ngOnInit() {
  }

  // FUNCION PARA REGISTRAR UN USUARIO
  registerUser(): void {

    const md5 = new Md5();

    let password: string | Int32Array;
    password = md5.appendStr(this.contrasena).end();

    this.model.con_usu = password.toString();

    this.model.col_usu = 'prueba';

    this.apiService.registerUser(this.model).subscribe(
      res => {
        this.contrasena = '';
        if ((res === null) || (res === '')) {
          this.modal = true;
        } else {
          this.modalCorrecto = true;
        }


      },
      err => {

        alert('Error al mandar la peticion a la API');

      }
    );

  }

  ocultarModal() {
    if (this.modalCorrecto === true) {
      this.modalCorrecto = false;
      this.router.navigate(['/']);
    } else {
      this.modal = false;
      this.modalCorrecto = false;
    }
  }

}

export interface RegistroViewModel {
  nick_usu: string;
  nom_usu: string;
  ape_usu: string;
  con_usu: string;
  cor_usu: string;
  col_usu: string;
}
