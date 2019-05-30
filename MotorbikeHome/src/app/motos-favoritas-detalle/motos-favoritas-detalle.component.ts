import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Motos } from '../model/motos';
import { Marcas } from '../model/marcas';
import { ApiService } from '../shared/api.service';
import { Usuario } from '../model/usuario';
import { LoginService } from '../shared/login.service';
import { Comentario } from '../model/comentario';

@Component({
  selector: 'app-motos-favoritas-detalle',
  templateUrl: './motos-favoritas-detalle.component.html',
  styleUrls: ['./motos-favoritas-detalle.component.css']
})
export class MotosFavoritasDetalleComponent implements OnInit {

  comentarios: any;

  registrarComentario: Comentario = {
    id_com: 0,
    id_mot: 0,
    id_usu: 0,
    tex_com: '',
  };

  usuarioLog: Usuario;
  idMotos: any;

  usuComent: Usuario[] = [];

  logueado: boolean;
  motoFav: boolean;

  model: MotoFavoritaModel = {
    id_prod: 0,
    id_usu: 0
  };

  moto: Motos[] = [];
  marcas: Marcas[] = [];

  public motoId;

  constructor(private route: ActivatedRoute,
              private apiService: ApiService,
              private loginService: LoginService) { }

  ngOnInit() {
    this.usuarioLog = this.loginService.getUsuarioLog();
    if (this.usuarioLog != null) {
      this.logueado = true;
      this.getAllIdMotosFav();
    } else {
      this.logueado = false;
    }
    const id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.motoId = id;
    this.getMotoById();
    this.getAllMarcas();
    this.loginService.setViewAdmin(false);
    this.getAllComentarios();
    this.getComentNickUsu();
  }

  // OBTENER MOTO POR ID
  getMotoById(): void {

    this.apiService.getMotoById(this.motoId).subscribe(
      res => {
        this.moto = res;
      },
      err => {
        alert('Ha ocurrido un error al cargar la moto');
      }
    );
  }

  // OBTENER TODAS LAS MARCAS
  public getAllMarcas() {

    this.apiService.getAllMarcas().subscribe(
      res => {
        this.marcas = res;
      },
      err => {
        alert('Ha ocurrido un error al obtener las motos de la api');
      }
    );

  }

  // FUNCION PARA AÑADIR UNA MOTO A FAVORITAS
  public addMotoFavorita() {

    this.model.id_usu = this.usuarioLog.id_usu;
    this.model.id_prod = this.motoId;

    this.apiService.addMotoFavorita(this.model).subscribe(
      res => {
        this.motoFav = true;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la api');
      }
    );

  }

  // FUNCION PARA SABER SI LA MOTO SELECCIONADA ES FAVORITA
  // DEL USUARIO ACTUAL
  public getAllIdMotosFav() {

    this.apiService.getIdMotosFav(this.usuarioLog.id_usu).subscribe(
      res => {
        this.idMotos = res;

        this.motoFav = false;

        for (let id_mot of this.idMotos) {
          if (id_mot === this.motoId) {
            this.motoFav = true;
            console.log('MOTO FAVORITA');
          }
        }
      },
      err => {
        alert('Ha ocurrido un error al establecer conexion la api');
      }
    );

  }

  // FUNCION PARA ELIMINAR UNA MOTO DE FAVORITAS
  public eliminarMotoFavorita() {

    this.model.id_usu = this.usuarioLog.id_usu;
    this.model.id_prod = this.motoId;

    this.apiService.eliminarMotoFavorita(this.model).subscribe(
      res => {
        this.motoFav = false;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la api');
      }
    );
  }


  // FUNCION PARA OBTENER TODOS LOS COMENTARIOS DE LA MOTO
  public getAllComentarios() {

    this.apiService.getComentarios(this.motoId).subscribe(
      res => {

        this.comentarios = res;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la api');
      }
    );
  }

  // FUNCION PARA OBTENER TODOS LOS USUARIOS
  public getComentNickUsu() {

    this.apiService.getUsuarios().subscribe(
      res => {
        this.usuComent = res;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la api');
      }
    );
  }

  public sendComentario() {

    this.registrarComentario.id_usu = this.usuarioLog.id_usu;
    this.registrarComentario.id_mot = this.motoId;

    this.apiService.postComentario(this.registrarComentario).subscribe(
      res => {
        this.registrarComentario.tex_com = '';
        this.getAllComentarios();
        this.getComentNickUsu();
      },
      err => {
        alert('Ha ocurrido un error al conectar con la api');
      }
    );
  }


}


export interface MotoFavoritaModel {
  id_prod: number;
  id_usu: number;
}

export interface ComentarioModel {
  id_com: number;
  id_usu: number;
  id_mot: number;
  tex_com: string;
}
