import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { Motos } from '../model/motos';
import { Usuario } from '../model/usuario';
import { ApiService } from '../shared/api.service';
import { LoginService } from '../shared/login.service';

@Component({
  selector: 'app-motos-favoritas',
  templateUrl: './motos-favoritas.component.html',
  styleUrls: ['./motos-favoritas.component.css']
})
export class MotosFavoritasComponent implements OnInit {

  filtro: FiltroViewModel = {
    nom_mot: '',
    id_mar: 0,
    id_mod: 0
  };

  idMotos: any;

  usuarioLog: Usuario;

  motos: Motos[] = [];
  todasMotos: Motos[] = [];
  todasMotosFiltro: Motos[] = [];

  textoBusqueda: string;

  totalMotos: number;
  totalPaginas: number;
  paginaActual: number;

  constructor(private apiService: ApiService,
              private loginService: LoginService) { }

  pagActual: number = 1;

  ngOnInit() {
    this.usuarioLog = this.loginService.getUsuarioLog();
    this.getAllIdMotosFav();
    this.loginService.setViewAdmin(true);
  }

  // FUNCION PARA OBTENER EL ID DE LAS MOTOS FAVORITAS
  public getAllIdMotosFav() {

    this.apiService.getIdMotosFav(this.usuarioLog.id_usu).subscribe(
      res => {
        this.idMotos = res;
        this.getAllMotosFav();
      },
      err => {
        alert('Ha ocurrido un error al establecer conexion la api');
      }
    );

  }

  // FUNCION PARA OBTENER LOS DATOS DE LAS MOTOS FAVORITAS

  public getAllMotosFav() {
    this.apiService.getMotosFav(this.idMotos).subscribe(
      res => {
        console.log(res);
        this.motos = res;
        this.todasMotos = res;

      },
      err => {
        alert('Ha ocurrido un error al establecer conexion la API');
      }
    );

  }

  // FUNCION PARA RECIVIR DATOS DEL FILTRO
  // Y PARA APLICAR DATOS DEL FILTRO
  receiveFiltro($event) {
    this.filtro = ($event);
    this.motos = this.todasMotos;

    // COMPROBAMOS QUE EL CAMPO NOMBRE NO ESTA VACIO
    // PARA ASIGNARSELO A LA VARIABLE TEXTO BUSQUEDA
    if (this.filtro.nom_mot !== '') {
      this.textoBusqueda = this.filtro.nom_mot;
    } else {
      this.textoBusqueda = '';
    }

    if ((this.filtro.id_mar.toString() !== '0') || (this.filtro.id_mod.toString() !== '0')) {
      console.log('El filtro no viene vacio');
      let x = 0;

      // CREAMOS UN BUCLE PARA RECORRER TODAS LAS MOTOS
      for (let i = 0; i < this.todasMotos.length; i ++) {

        // SI MARCA Y MODALIDAD SELECCIONADOS:
        if ((this.filtro.id_mar.toString() !== '0') && (this.filtro.id_mod.toString() !== '0')) {
          if ((this.todasMotos[i].id_mar === this.filtro.id_mar) && (this.todasMotos[i].id_mod === this.filtro.id_mod)) {
            this.todasMotosFiltro[x] = this.todasMotos[i];
            x ++;
          }
        }

        // SI SOLO MARCA SELECCIONADO:
        if ((this.filtro.id_mar.toString() !== '0') && (this.filtro.id_mod.toString() === '0')) {
          if (this.todasMotos[i].id_mar === this.filtro.id_mar) {
            this.todasMotosFiltro[x] = this.todasMotos[i];
            x ++;
          }
        }

        // SI SOLO MODALIDAD SELECCIONADO:
        if ((this.filtro.id_mar.toString() === '0') && (this.filtro.id_mod.toString() !== '0')) {
          if (this.todasMotos[i].id_mod === this.filtro.id_mod) {
            this.todasMotosFiltro[x] = this.todasMotos[i];
            x ++;
          }
        }

        // COMPROBAMOS QUE EL CAMPO NOMBRE NO ESTA VACIO
        // PARA ASIGNARSELO A LA VARIABLE TEXTO BUSQUEDA
        if (this.filtro.nom_mot !== '') {
          this.textoBusqueda = this.filtro.nom_mot;
        } else {
          this.textoBusqueda = '';
        }

      }
      console.log('FILTRO APLICADO:');
      console.log(this.todasMotosFiltro);
      this.motos = this.todasMotosFiltro;
      this.todasMotosFiltro = [];
      x = 0;
    } else {
      this.motos = this.todasMotos;

      // COMPROBAMOS QUE EL CAMPO NOMBRE NO ESTA VACIO
      // PARA ASIGNARSELO A LA VARIABLE TEXTO BUSQUEDA
      if (this.filtro.nom_mot !== '') {
        this.textoBusqueda = this.filtro.nom_mot;
      } else {
        this.textoBusqueda = '';
      }

    }

  }


}


export interface FiltroViewModel {
  nom_mot: string;
  id_mar: number;
  id_mod: number;
}

