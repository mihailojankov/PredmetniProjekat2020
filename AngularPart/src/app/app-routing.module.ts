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
import { LoginComponent } from './Components/login/login.component';
import { PocetnaComponent } from './Components/pocetna/pocetna.component';
import {RoleGuardService} from './Services/role-guard.service';


const routes: Routes = [
  {path: '', component: PocetnaComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registracija', component: RegistracijaKorisnikaComponent},
  {path: 'smerovi', component: PrikazSmerovaComponent},
  {path: 'smerovi/predmeti', component: PrikazPredmetaSmeraComponent},
  {path: 'smerovi/predmeti/detalji', component: DetaljiOPredmetuComponent},
  {path: 'clanAdministrativnogOsobljaProfil',
    component: ClanAdministrativnogOsobljaProfilComponent,
    canActivate: [RoleGuardService],
    data: {expectedRole: 'CLAN'}},
  {path: 'nastavnikProfil',
    component: NastavnikProfilComponent,
    canActivate: [RoleGuardService],
    data: {expectedRole: 'NASTAVNIK'}},
  {path: 'studentProfil',
    component: StudentProfilComponent,
    canActivate: [RoleGuardService],
    data: {expectedRole: 'STUDENT'}},
  {path: 'adminProfil', component: AdminProfilComponent,
    canActivate: [RoleGuardService],
    data: {expectedRole: 'ADMIN'}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
