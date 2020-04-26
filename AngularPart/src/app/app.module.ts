import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './Components/main-page/main-page.component';
import { RegistracijaKorisnikaComponent } from './Components/registracija-korisnika/registracija-korisnika.component';
import { PrikazFakultetaComponent } from './Components/prikaz-fakulteta/prikaz-fakulteta.component';
import { PrikazSmerovaComponent } from './Components/prikaz-smerova/prikaz-smerova.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    RegistracijaKorisnikaComponent,
    PrikazFakultetaComponent,
    PrikazSmerovaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
