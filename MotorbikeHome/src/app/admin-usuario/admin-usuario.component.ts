import { Component, OnInit } from '@angular/core';
import { ApiService } from '../shared/api.service';
import { Usuario } from '../model/usuario';
import { LoginService } from '../shared/login.service';

@Component({
  selector: 'app-admin-usuario',
  templateUrl: './admin-usuario.component.html',
  styleUrls: ['./admin-usuario.component.scss']
})
export class AdminUsuarioComponent implements OnInit {

  constructor(private apiService: ApiService,
              private loginService: LoginService) { }

  usuarios: Usuario[] = [];
  usuarioLog = this.loginService.getUsuarioLog();

  modal: boolean;
  modalNo: boolean;
  modalRolNo: boolean;
  modalUsuNo: boolean;

  usuToDelete: number;

  ngOnInit() {
    this.modal = false;
    this.modalNo = false;
    this.modalRolNo = false;
    this.modalUsuNo = false;
    this.getAllUsuarios();
  }

  // FUNCION PARA OBTENER TODOS LOS USUARIOS
  public getAllUsuarios() {

    this.apiService.getUsuarios().subscribe(
      res => {
        this.usuarios = res;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la api');
      }
    );
  }

  // FUNCION PARA MOSTRAR UN MODAL AL ELIMINAR UN USARIO
  public modalEliminar(idUsu: number) {

    if (this.usuarioLog.id_usu === idUsu) {
      this.modalNo = true;
    } else {
      this.modal = true;
      this.usuToDelete = idUsu;
    }

  }

  // FUNCION PARA ELIMINAR EL USUARIO
  public eliminarUsuario() {
    this.modalNo = false;

    this.apiService.deleteUserById(this.usuToDelete).subscribe(
      res => {
        this.getAllUsuarios();
        this.modal = false;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la API');
      }
    );

  }

  // FUNCION PARA ACTUALIZAR EL ROL DE UN USUARIO
  public actualizarRolUsu(usuario: Usuario) {

    if (usuario.id_usu === this.usuarioLog.id_usu) {
      this.modalUsuNo = true;
      this.getAllUsuarios();
    } else {

      if ((usuario.rol_usu >= 0) && (usuario.rol_usu <= 1)) {

        this.apiService.updateUsuById(usuario).subscribe(
          res => {
            this.getAllUsuarios();
          },
          err => {
            alert('Ha ocurrido un error al conectar con la API');
          }
        );

      } else {

        this.modalRolNo = true;
        this.getAllUsuarios();

      }

    }

  }

  // FUNCION PARA CANCELAR ELIMINAR EL USUARIO
  public cancelar() {
    this.modal = false;
    this.modalNo = false;
    this.modalRolNo = false;
    this.modalUsuNo = false;
    this.usuToDelete = 0;
  }
}
