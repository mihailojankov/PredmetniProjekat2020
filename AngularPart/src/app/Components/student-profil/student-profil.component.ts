import { Component, OnInit } from '@angular/core';
import { Predmet } from 'src/app/Models/predmet';
import { Rok } from 'src/app/Models/rok';
import { PredmetService } from 'src/app/Services/predmet.service';
import { RokService } from 'src/app/Services/rok.service';
import { FormBuilder } from '@angular/forms';
import { PrijavaIspita } from 'src/app/Models/prijava-ispita';
import { Ispit } from 'src/app/Models/ispit';
import { IspitService } from 'src/app/Services/ispit.service';
import { PrijavaIspitaService } from 'src/app/Services/prijava-ispita.service';
import { AuthService } from 'src/app/Services/auth.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Student } from 'src/app/Models/student';
import { ObserveOnMessage } from 'rxjs/internal/operators/observeOn';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-student-profil',
  templateUrl: './student-profil.component.html',
  styleUrls: ['./student-profil.component.css']
})
export class StudentProfilComponent implements OnInit {

  formaZaDodavanjePrijaveIspita;

  predmeti: Predmet[];
  rokovi: Rok[];
  ispiti: Ispit[];
  trenutniStudent: Student;
  prijaveIspita: PrijavaIspita[];


  prikazFormePrijaveIspita = false;

  constructor(private servicePredmet: PredmetService, private serviceRok: RokService,
              private serviceIspit: IspitService, private authService: AuthService, private servicePrijavaIspita: PrijavaIspitaService, private formBuilder: FormBuilder,
              private router: Router) {


    this.formaZaDodavanjePrijaveIspita = formBuilder.group({
      id: 0,
      datumPrijave: null,
      student: null,
      rok: null,
      ispit: null
    }as PrijavaIspita);
   }

  ngOnInit(): void {
    this.dobaviSve();

  }

  dobaviSve() {
    this.serviceIspit.dobavi().subscribe(data => this.ispiti = data);
    this.servicePredmet.dobavi().subscribe(data => this.predmeti = data);
    this.serviceRok.dobavi().subscribe(data => {
      this.rokovi = data;
    });

    this.servicePrijavaIspita.dobavi().subscribe(data => this.prijaveIspita = data);

    this.authService.getCurrentUser().subscribe(data => this.trenutniStudent = data);
  }

  dodajPrijavuIspita(data) {
    const novaPrijavaIspita = {
      id: 0,
      datumPrijave: new Date(),
      student: this.trenutniStudent,
      rok: data.rok,
      ispit: data.ispit
    };
    this.servicePrijavaIspita.dodaj(novaPrijavaIspita).subscribe(data => {
      window.alert('Uspesno ste prijavili ispit');
      this.dobaviSve();
    });
  }

  prikazFormePrijaveIspitaFunction(event) {
    this.prikazFormePrijaveIspita = !this.prikazFormePrijaveIspita;
  }

}
