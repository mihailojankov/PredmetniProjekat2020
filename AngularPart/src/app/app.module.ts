import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './Components/main-page/main-page.component';
import { RegistracijaKorisnikaComponent } from './Components/registracija-korisnika/registracija-korisnika.component';
import { PrikazFakultetaComponent } from './Components/prikaz-fakulteta/prikaz-fakulteta.component';
import { PrikazSmerovaComponent } from './Components/prikaz-smerova/prikaz-smerova.component';
import { PrikazPredmetaSmeraComponent } from './Components/prikaz-predmeta-smera/prikaz-predmeta-smera.component';
import { DetaljiOPredmetuComponent } from './Components/detalji-opredmetu/detalji-opredmetu.component';
import { LoginComponent } from './Components/login/login.component';
import { Interseptor } from './Models/interseptor';
import { ClanAdministrativnogOsobljaProfilComponent } from './Components/clan-administrativnog-osoblja-profil/clan-administrativnog-osoblja-profil.component';
import { NastavnikProfilComponent } from './Components/nastavnik-profil/nastavnik-profil.component';
import { StudentProfilComponent } from './Components/student-profil/student-profil.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    RegistracijaKorisnikaComponent,
    PrikazFakultetaComponent,
    PrikazSmerovaComponent,
    PrikazPredmetaSmeraComponent,
    DetaljiOPredmetuComponent,
    LoginComponent,
    ClanAdministrativnogOsobljaProfilComponent,
    NastavnikProfilComponent,
    StudentProfilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2SearchPipeModule

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
