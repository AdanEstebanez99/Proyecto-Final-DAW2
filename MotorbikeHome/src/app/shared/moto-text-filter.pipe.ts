import { Pipe, PipeTransform } from '@angular/core';
import { Motos } from '../model/motos';

@Pipe({
  name: 'motoTextFilter'
})
export class MotoTextFilterPipe implements PipeTransform {

  transform(motos: Motos[], nombre: string): Motos[] {
    if (nombre == null || nombre === '') {
      return motos;
    } else {
      return motos.filter(n => n.nom_mot.includes(nombre));
    }
  }

}
