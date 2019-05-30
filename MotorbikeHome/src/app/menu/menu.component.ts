import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AppModule } from '../app.module';
import { Modalidades } from '../model/modalidades';
import { Marcas } from '../model/marcas';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  model: FiltroViewModel = {
    nom_mot: '',
    id_mar: 0,
    id_mod: 0
  };

  modalidades: Modalidades[] = [];
  marcas: Marcas[] = [];

  @Output() filtroEvent = new EventEmitter<FiltroViewModel>();

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getAllMarcas();
    this.getAllModalidades();
  }

    // FUNCION PARA OBTENER TODAS LAS MODALIDADES
    public getAllModalidades() {

      this.apiService.getAllModalidades().subscribe(
        res => {
          this.modalidades = res;
        },
        err => {
          alert('Ha ocurrido un error al obtener las motos de la api');
        }
      );

    }

    // FUNCION PARA OBTENER TODAS LAS MARCAS
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

    // FUNCION PARA APLICAR EL FILTRO
    public aplicarFiltro() {
      console.log('Aplicando Filtro');
      console.log(this.model);

      this.filtroEvent.emit(this.model);
    }

}

export interface FiltroViewModel {
  nom_mot: string;
  id_mar: number;
  id_mod: number;
}
