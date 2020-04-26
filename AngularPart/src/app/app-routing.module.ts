import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistracijaKorisnikaComponent } from './Components/registracija-korisnika/registracija-korisnika.component';
import { PrikazSmerovaComponent } from './Components/prikaz-smerova/prikaz-smerova.component';
import { PrikazFakultetaComponent } from './Components/prikaz-fakulteta/prikaz-fakulteta.component';


const routes: Routes = [
  {path:"", component:PrikazFakultetaComponent},
  {path:"registracija", component:RegistracijaKorisnikaComponent},
  {path:"smerovi", component:PrikazSmerovaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
