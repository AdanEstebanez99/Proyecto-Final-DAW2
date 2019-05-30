import { Component, OnInit } from '@angular/core';
import { Motos } from '../model/motos';
import { ApiService } from '../shared/api.service';
import { Marcas } from '../model/marcas';
import { Modalidades } from '../model/modalidades';

@Component({
  selector: 'app-admin-motos',
  templateUrl: './admin-motos.component.html',
  styleUrls: ['./admin-motos.component.scss']
})
export class AdminMotosComponent implements OnInit {

  constructor(private apiService: ApiService) { }

  motos: Motos[];
  motoRegistro: Motos[];

  marcas: Marcas[] = [];
  modalidades: Modalidades[] = [];

  modal: boolean;
  modalNo: boolean;
  modalNulo: boolean;

  motoToDelete: number;

  ngOnInit() {
    this.modal = false;
    this.modalNo = false;
    this.modalNulo = false;
    this.getMotos();
    this.getAllMarcas();
    this.getAllModalidades();
  }

  // FUNCION PARA OBTENER TODAS LAS MOTOS
  public getMotos() {

    this.apiService.getAllMotos().subscribe(
      res => {
        this.motos = res;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la api');
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

  // OBTENER TODAS LAS MODALIDADES
  public getAllModalidades() {

    this.apiService.getAllModalidades().subscribe(
      res => {
        this.modalidades = res;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la API');
      }
    );
  }

  // FUNCION PARA MOSTRAR UN MODAL AL ELIMINAR UNA MOTO
  public modalEliminar(idMot: number) {

      this.modal = true;
      this.motoToDelete = idMot;

  }

  // FUNCION PARA ELIMINAR LA MOTO
  public eliminarMoto() {
    this.modalNo = false;

    this.apiService.deleteMotoById(this.motoToDelete).subscribe(
      res => {
        this.getMotos();
        this.modal = false;
      },
      err => {
        alert('Ha ocurrido un error al conectar con la API');
      }
    );

  }

  // FUNCION PARA CANCELAR ELIMINAR EL USUARIO
  public cancelar() {
    this.modal = false;
    this.modalNo = false;
    this.modalNulo = false;
    this.motoToDelete = 0;
  }

  // FUNCION PARA ACTUALIZAR UNA MOTO
  public actualizarMoto(updateMoto: Motos) {

    if ((updateMoto.cil_mot === '') || (updateMoto.cic_mot === '') || (updateMoto.ref_mot === '') ||
        (updateMoto.trn_mot === '') || (updateMoto.nmar_mot === '') || (updateMoto.cha_mot === '') ||
        (updateMoto.frd_mot === '') || (updateMoto.frt_mot === '') || (updateMoto.rud_mot === '') ||
        (updateMoto.rut_mot === '') || (updateMoto.pes_mot === '')) {

          this.modalNulo = true;
          this.getMotos();

    } else {

      this.apiService.updateMotoById(updateMoto).subscribe(
        res => {
          this.getMotos();
        },
        err => {
          alert('Ha ocurrido un error al conectar con la API');
        }
      );
    }

  }

}
