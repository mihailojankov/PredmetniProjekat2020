import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistracijaKorisnikaComponent } from './Components/registracija-korisnika/registracija-korisnika.component';
import { PrikazFakultetaComponent } from './Components/prikaz-fakulteta/prikaz-fakulteta.component';
import { PrikazSmerovaComponent } from './Components/prikaz-smerova/prikaz-smerova.component';
import { PrikazPredmetaSmeraComponent } from './Components/prikaz-predmeta-smera/prikaz-predmeta-smera.component';
import { DetaljiOPredmetuComponent } from './Components/detalji-opredmetu/detalji-opredmetu.component';
import { LoginComponent } from './Components/login/login.component';
import { Interseptor } from './Models/interseptor';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ClanAdministrativnogOsobljaProfilComponent } from './Components/clan-administrativnog-osoblja-profil/clan-administrativnog-osoblja-profil.component';
import { NastavnikProfilComponent } from './Components/nastavnik-profil/nastavnik-profil.component';
import { StudentProfilComponent } from './Components/student-profil/student-profil.component';
import { AdminProfilComponent } from './Components/admin-profil/admin-profil.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatGridListModule } from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTabsModule} from '@angular/material/tabs';
import { PocetnaComponent } from './Components/pocetna/pocetna.component';





@NgModule({
  declarations: [
    AppComponent,
    RegistracijaKorisnikaComponent,
    PrikazFakultetaComponent,
    PrikazSmerovaComponent,
    PrikazPredmetaSmeraComponent,
    DetaljiOPredmetuComponent,
    LoginComponent,
    ClanAdministrativnogOsobljaProfilComponent,
    NastavnikProfilComponent,
    StudentProfilComponent,
    AdminProfilComponent,
    PocetnaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    BrowserAnimationsModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatSlideToggleModule,
    MatFormFieldModule,
    MatSidenavModule,
    MatTabsModule
    

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interseptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
