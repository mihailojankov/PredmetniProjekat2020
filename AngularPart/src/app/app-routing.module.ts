import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistracijaKorisnikaComponent } from './Components/registracija-korisnika/registracija-korisnika.component';
import { PrikazSmerovaComponent } from './Components/prikaz-smerova/prikaz-smerova.component';
import { PrikazFakultetaComponent } from './Components/prikaz-fakulteta/prikaz-fakulteta.component';
import { PrikazPredmetaSmeraComponent } from './Components/prikaz-predmeta-smera/prikaz-predmeta-smera.component';
import { DetaljiOPredmetuComponent } from './Components/detalji-opredmetu/detalji-opredmetu.component';


const routes: Routes = [
  {path:"", component:PrikazFakultetaComponent},
  {path:"registracija", component:RegistracijaKorisnikaComponent},
  {path:"smerovi", component:PrikazSmerovaComponent},
  {path:"smerovi/predmeti", component:PrikazPredmetaSmeraComponent},
  {path:"smerovi/predmeti/detalji", component:DetaljiOPredmetuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
