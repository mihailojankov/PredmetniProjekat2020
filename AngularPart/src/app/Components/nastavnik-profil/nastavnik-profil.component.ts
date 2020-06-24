import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/Models/student';
import { Predmet } from 'src/app/Models/predmet';
import { Nastavnik } from 'src/app/Models/nastavnik';
import { PrijavaIspita } from 'src/app/Models/prijava-ispita';
import { StudentService } from 'src/app/Services/student.service';
import { PredmetService } from 'src/app/Services/predmet.service';
import { Rok } from 'src/app/Models/rok';
import { RokService } from 'src/app/Services/rok.service';
import { PrijavaIspitaService } from 'src/app/Services/prijava-ispita.service';
import { IshodIspita } from 'src/app/Models/ishod-ispita';
import { IshodIspitaService } from 'src/app/Services/ishod-ispita.service';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-nastavnik-profil',
  templateUrl: './nastavnik-profil.component.html',
  styleUrls: ['./nastavnik-profil.component.css']
})
export class NastavnikProfilComponent implements OnInit {

  pretraga;

  studenti:Student[];
  predmeti:Predmet[];
  trenutniNastavnik:Nastavnik;
  prijaveIspita:PrijavaIspita[];
  rokovi:Rok[];

  constructor(private studentService:StudentService, private predmetService:PredmetService, private rokService:RokService,
    private prijavaIspitaService:PrijavaIspitaService, private ishodIspitaService:IshodIspitaService, private authService:AuthService) { }

  ngOnInit(): void {
    this.dobaviSve();
  }

  dobaviSve(){
    this.rokService.dobavi().subscribe(data => this.rokovi = data);
    this.authService.getCurrentUser().subscribe(data => {
      console.log(data);
      this.trenutniNastavnik = data;
      this.predmetService.dobaviPoProfesoru(this.trenutniNastavnik.id).subscribe(data => this.predmeti = data);
    });
  }

  pronadjiStudentaPoPredmetu(data){
    this.studentService.pronadjiStudentePoPredmetu(data.id).subscribe(data =>this.studenti = data);
  }

}
