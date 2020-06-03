import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistracijaKorisnikaComponent } from './Components/registracija-korisnika/registracija-korisnika.component';
import { PrikazSmerovaComponent } from './Components/prikaz-smerova/prikaz-smerova.component';
import { PrikazFakultetaComponent } from './Components/prikaz-fakulteta/prikaz-fakulteta.component';
import { PrikazPredmetaSmeraComponent } from './Components/prikaz-predmeta-smera/prikaz-predmeta-smera.component';
import { DetaljiOPredmetuComponent } from './Components/detalji-opredmetu/detalji-opredmetu.component';
import { ClanAdministrativnogOsobljaProfilComponent } from './Components/clan-administrativnog-osoblja-profil/clan-administrativnog-osoblja-profil.component';
import { NastavnikProfilComponent } from './Components/nastavnik-profil/nastavnik-profil.component';
import { StudentProfilComponent } from './Components/student-profil/student-profil.component';
import { AdminProfilComponent } from './Components/admin-profil/admin-profil.component';


const routes: Routes = [
  {path:"", component:PrikazFakultetaComponent},
  {path:"registracija", component:RegistracijaKorisnikaComponent},
  {path:"smerovi", component:PrikazSmerovaComponent},
  {path:"smerovi/predmeti", component:PrikazPredmetaSmeraComponent},
  {path:"smerovi/predmeti/detalji", component:DetaljiOPredmetuComponent},
  {path:"clanAdministrativnogOsobljaProfil", component:ClanAdministrativnogOsobljaProfilComponent},
  {path:"nastavnikProfil", component:NastavnikProfilComponent},
  {path:"studentProfil", component:StudentProfilComponent},
  {path:"adminProfil", component:AdminProfilComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
