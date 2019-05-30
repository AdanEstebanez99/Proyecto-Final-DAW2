import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Motos } from '../model/motos';
import { Modalidades } from '../model/modalidades';
import { Marcas } from '../model/marcas';
import { RegistroViewModel } from '../registro/registro.component';
import { MotoFavoritaModel } from '../detalle-moto/detalle-moto.component';
import { Usuario } from '../model/usuario';
import { Comentario } from '../model/comentario';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private BASE_URL = 'http://localhost:8080/api';

  // TODOS
  private ALL_MOTOS_URL = this.BASE_URL + '/motos';
  private ALL_MODALIDADES_URL = this.BASE_URL + '/modalidad';
  private ALL_MARCAS_URL = this.BASE_URL + '/marca';
  private ALL_USUARIOS_URL = this.BASE_URL + '/usuarios';

  // POR ID'S
  private MOTO_BY_ID_URL = this.BASE_URL + '/motos/';
  private USUARIO_BY_ID_URL = this.BASE_URL + '/usuarios/';
  private MARCA_BY_ID_URL = this.BASE_URL + '/marca/';
  private MODALIDAD_BY_ID_URL = this.BASE_URL + '/marca/';
  private COMPRUEBA_USUARIO_URL = this.BASE_URL + '/usuarios/nick';
  private ALL_MOTOS_FAVORITAS = this.BASE_URL + '/motos/favoritasId';
  private ALL_MOTOS_FAVORITAS_DETALLE = this.BASE_URL + '/motos/favoritas/detalles';
  private ALL_COMENTARIO_MOTO = this.BASE_URL + '/comentario/all';

  // CREACIONES O REGISTROS
  private REGISTRAR_USUARIO_URL = this.BASE_URL + '/usuarios';
  private INICIO_SESION_URL = this.BASE_URL + '/usuarios/login';
  private ADD_MOTO_FAV_URL = this.BASE_URL + '/motos/favoritas';
  private POST_COMENTARIO_URL = this.BASE_URL + '/comentario';

  // ELIMINACIONES
  private DELETE_MOTO_FAV_URL = this.BASE_URL + '/motos/favoritas/delete';
  private DELETE_USER_BY_ID_URL = this.BASE_URL + '/usuarios/';
  private DELETE_MOTO_BY_ID_URL = this.BASE_URL + '/motos/';

  constructor(private http: HttpClient) {

  }

  // FUNCION PARA OBTENER TODAS LAS MOTOS
  getAllMotos(): Observable<Motos[]> {
    return this.http.get<Motos[]>(this.ALL_MOTOS_URL);
  }

  // FUNCION PARA OBTENER TODOS LOS USUARIOS
  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.ALL_USUARIOS_URL);
  }

  // FUNCION PARA OBTENER EL ID DE TODAS LAS MOTOS FAVORITAS DE CADA USUARIO
  getIdMotosFav(idUsu: number) {
    return this.http.post(this.ALL_MOTOS_FAVORITAS, idUsu);
  }

  // FUNCION PARA OBTENER LAS MOTOS FAVORITAS EN FUNCION DEL USUARIO
  getMotosFav(idMotosFav: any): Observable<Motos[]> {
    return this.http.post<Motos[]>(this.ALL_MOTOS_FAVORITAS_DETALLE, idMotosFav);
  }

  // FUNCION PARA OBTENER TODAS LAS MODALIDADES
  getAllModalidades(): Observable<Modalidades[]> {
    return this.http.get<Modalidades[]>(this.ALL_MODALIDADES_URL);
  }

  // FUNCION PARA OBTENER TODAS LAS MARCAS
  getAllMarcas(): Observable<Marcas[]> {
    return this.http.get<Marcas[]>(this.ALL_MARCAS_URL);
  }

  // FUNCION PARA OBTENER MOTOS POR ID
  getMotoById(motoId): Observable<Motos[]> {
    return this.http.get<Motos[]>(this.MOTO_BY_ID_URL + motoId);
  }

  // FUNCION PARA ACTUALIZAR MOTOS POR ID
  updateMotoById(moto) {
    return this.http.put(this.MOTO_BY_ID_URL + moto.id_mot, moto);
  }

  // FUNCION PARA ACTUALIZAR ROL DE USUARIO POR ID
  updateUsuById(usuario) {
    return this.http.put(this.USUARIO_BY_ID_URL + usuario.id_usu, usuario);
  }

  // FUNCION PARA ELIMINAR USUARIOS POR ID
  deleteUserById(userId) {
    return this.http.delete(this.DELETE_USER_BY_ID_URL + userId);
  }

  // FUNCION PARA ELIMINAR UNA MOTO POR ID
  deleteMotoById(motoId) {
    return this.http.delete(this.DELETE_MOTO_BY_ID_URL + motoId);
  }

  // FUNCION PARA OBTENER MARCAS POR ID
  getMarcaById(marcaId): Observable<Marcas[]> {
    return this.http.get<Marcas[]>(this.MARCA_BY_ID_URL + marcaId);
  }

  // FUNCION PARA OBTENER MODALIDADES POR ID
  getModalidadesById(modalidadesId): Observable<Modalidades[]> {
    return this.http.get<Modalidades[]>(this.MODALIDAD_BY_ID_URL + modalidadesId);
  }

  // FUNCION PARA REGISTRAR USUARIOS
  registerUser(registerUser: RegistroViewModel): Observable<any> {
    return this.http.post(this.REGISTRAR_USUARIO_URL, registerUser);
  }

  // FUNCION PARA COMPROBAR SI EL USUARIO YA ESTA REGISTRADO
  getUsuRegistrado(usuario: string) {

    return this.http.post(this.COMPRUEBA_USUARIO_URL, usuario);
  }

  // FUNCION PARA COMPROBAR LOGUEO DE USUARIO
  getInicioUsuario(usuario: string , contrasena: string) {

    let datos: any = {
      nick_usu: usuario,
      con_usu: contrasena
    };

    return this.http.post(this.INICIO_SESION_URL, datos);
  }

  // FUNCION PARA AÑADIR UNA MOTO FAVORITA
  addMotoFavorita(addMoto: MotoFavoritaModel): Observable<any> {
    return this.http.post(this.ADD_MOTO_FAV_URL, addMoto);
  }

  // FUNCION PARA ELIMINAR UNA MOTO DE FAVORITAS
  eliminarMotoFavorita(deleteMoto: MotoFavoritaModel): Observable<any> {
    return this.http.post(this.DELETE_MOTO_FAV_URL, deleteMoto);
  }

  // FUNCION PARA OBTENER TODOS LOS COMENTARIOS DE UNA MOTO
  getComentarios(idMot: number) {
    return this.http.post(this.ALL_COMENTARIO_MOTO, idMot);
  }

  // FUNCION PARA REGISTRAR UN COMENTARIO
  postComentario(sendComentario: Comentario): Observable<any> {
    return this.http.post(this.POST_COMENTARIO_URL, sendComentario);
  }

}
