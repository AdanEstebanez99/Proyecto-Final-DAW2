import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Router, Routes, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DropdownModule } from 'angular-custom-dropdown';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';

import { MaterialModule } from './material';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContenidoComponent } from './contenido/contenido.component';
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';
import { InicioComponent } from './inicio/inicio.component';
import { RegistroComponent } from './registro/registro.component';
import { NoEncontradoComponent } from './no-encontrado/no-encontrado.component';
import { DetalleMotoComponent } from './detalle-moto/detalle-moto.component';
import { MenuComponent } from './menu/menu.component';
import { MotoTextFilterPipe } from './shared/moto-text-filter.pipe';
import { AdminMotosComponent } from './admin-motos/admin-motos.component';
import { AdminUsuarioComponent } from './admin-usuario/admin-usuario.component';
import { LoginService } from './shared/login.service';
import { AdminService } from './shared/admin.service';
import { AjustesUsuarioComponent } from './ajustes-usuario/ajustes-usuario.component';
import { MotosFavoritasComponent } from './motos-favoritas/motos-favoritas.component';
import { MotosFavoritasDetalleComponent } from './motos-favoritas-detalle/motos-favoritas-detalle.component';
import { MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';


const appRoutes: Routes = [

  {
    // RUTA A PAGINA DE REGISTRO
    path: 'registro',
    component: RegistroComponent
  },
  {
    // RUTA A PAGINA PRINCIPAL
    path: 'contenido',
    component: ContenidoComponent
  },
  {
    // RUTA A PAGINA DE DETALLES DE MOTO
    path: 'contenido/:id',
    component: DetalleMotoComponent
  },
  {
    // RUTA A PAGINA DE ADMINISTRAR MOTOS
    path: 'administrar/motos',
    component: AdminMotosComponent,
    canActivate: [LoginService, AdminService]
  },
  {
    // RUTA A PAGINA DE ADMINISTRAR USUARIOS
    path: 'administrar/usuarios',
    component: AdminUsuarioComponent,
    canActivate: [LoginService, AdminService]
  },
  {
    // RUTA A PAGINA DE AJUSTES DE LOS USUARIOS
    path: 'ajustes',
    component: AjustesUsuarioComponent,
    canActivate: [LoginService]
  },
  {
    // RUTA A PAGINA DE MOTOS FAVORITAS
    path: 'favoritas',
    component: MotosFavoritasComponent,
    canActivate: [LoginService]
  },
  {
    // RUTA A PAGINA DE DETALLES DE MOTOS FAVORITAS
    path: 'favoritas/:id',
    component: MotosFavoritasDetalleComponent,
    canActivate: [LoginService]
  },
  {
    // RUTA POR DEFECTO
    path: '',
    component: InicioComponent,
    pathMatch: 'full'
  },
  {
    // RUTA EN CASO DE ERROR
    path: '**',
    component: NoEncontradoComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ContenidoComponent,
    BreadcrumbComponent,
    InicioComponent,
    RegistroComponent,
    NoEncontradoComponent,
    DetalleMotoComponent,
    MenuComponent,
    MotoTextFilterPipe,
    AdminMotosComponent,
    AdminUsuarioComponent,
    AjustesUsuarioComponent,
    MotosFavoritasComponent,
    MotosFavoritasDetalleComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    BrowserAnimationsModule,
    DropdownModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    NgxPaginationModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
