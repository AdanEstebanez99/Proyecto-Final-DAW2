import { Component, OnInit } from '@angular/core';
import { Motos } from '../model/motos';
import { ApiService } from '../shared/api.service';
import { LoginService } from '../shared/login.service';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-ajustes-usuario',
  templateUrl: './ajustes-usuario.component.html',
  styleUrls: ['./ajustes-usuario.component.scss']
})
export class AjustesUsuarioComponent implements OnInit {

  usuarioLog: Usuario;
  infoUsu: Usuario;

  modalNo: boolean;

  constructor(private apiService: ApiService,
              private loginService: LoginService) { }

  ngOnInit() {
    this.modalNo = false;
    this.usuarioLog = this.loginService.getUsuarioLog();
    this.infoUsu = this.usuarioLog;
  }

    // FUNCION PARA ACTUALIZAR LOS DATOS DEL USUARIO
    public actualizarUsu(updateUsuario: Usuario) {

      if ((updateUsuario.ape_usu === '') || (updateUsuario.nom_usu === '')) {
        this.modalNo = true;
        this.usuarioLog = this.loginService.getUsuarioLog();
        this.infoUsu = this.loginService.getUsuarioLog();
      } else {

        this.apiService.updateUsuById(updateUsuario).subscribe(
          res => {
            this.usuarioLog = this.loginService.getUsuarioLog();
            this.infoUsu = this.loginService.getUsuarioLog();
          },
          err => {
            alert('Ha ocurrido un error al conectar con la API');
          }
        );

      }

    }

    // FUNCION PARA CANCELAR ELIMINAR EL USUARIO
    public cancelar() {
      this.modalNo = false;
    }

    // FUNCION PARA LA IMAGEN DEL USUARIO
    public obtenerImagen(file) {
      let files = file.files;
      if (files.length > 0) {
        if (file.files[0].type.includes('image')) {
          this.getBase64(files[0]);
        } else {
          alert('Debes seleccionar una imagen');
        }
      }
    }

    // FUNCION PARA CONVERTIR A BASE64 UNA IMAGEN
    public getBase64(file) {
      let reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => {

        if (reader.result.toString().includes('image')) {
          this.infoUsu.img_usu = reader.result.toString();
          this.actualizarUsu(this.infoUsu);
        }

        console.log(reader.result);
      };
      reader.onerror = (error) => {
        console.log('Error: ', error);
      };
    }

}
