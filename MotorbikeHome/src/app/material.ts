import { NgModule } from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {MatMenuModule} from '@angular/material/menu';

@NgModule({
  imports: [MatButtonModule,
            MatCheckboxModule,
            MatMenuModule
            ],

  exports: [MatButtonModule,
            MatCheckboxModule,
            MatMenuModule],
})
export class MaterialModule { }
