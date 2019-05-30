import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { ApiService } from '../shared/api.service';
import { Motos } from '../model/motos';

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.scss']
})
export class BreadcrumbComponent implements OnInit {

  moto: Motos[] = [];

  public motoId;

  routed: string;
  breadcrumbList: Array<any>;
  routeLinks: number;
  count: number;

  constructor(location: Location, router: Router,
              private route: ActivatedRoute,
              private apiService: ApiService) {
    router.events.subscribe((val) => {
      if (location.path() !== '') {
        this.routed = location.path();
        this.breadcrumbList = this.routed.split('/');
        this.count = this.breadcrumbList.length;
      }
    });
  }

  ngOnInit() {
    console.log('debug');

    // COMPROBAMOS QUE EL VALOR DE ID DE LA
    // URL EXISTA PARA QUE NO SE ASIGNE EL VALOR
    if (isNaN(parseInt(this.route.snapshot.paramMap.get('id')))) {
    } else {
      const id = parseInt(this.route.snapshot.paramMap.get('id'));

      this.motoId = id;
      this.getMotoById();

      // SI EL ID DE LA URL COINCIDE CON EL ID DE
      // LA MOTO QUE ESTAMOS MOSTRANDO, LE DAMOS EL
      // VALOR DEL NOMBRE DE LA MOTO A LA ULTIMA
      // POSICION DEL ARRAY (DONDE IRIA EL ID)
      // PARA EN LAS MIGAS DE PAN MOSTRAR EL NOMBRE
      if ((this.breadcrumbList[this.count - 1]).toString() === this.motoId.toString()) {
        this.breadcrumbList[this.count - 1] = 'detalleMoto';
      }

    }

  }

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

}
