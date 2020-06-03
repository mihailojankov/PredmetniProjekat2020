import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/Services/student.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { Student } from 'src/app/Models/student';
import { RegistrovanKorisnik } from 'src/app/Models/registrovan-korisnik';

@Component({
  selector: 'app-clan-administrativnog-osoblja-profil',
  templateUrl: './clan-administrativnog-osoblja-profil.component.html',
  styleUrls: ['./clan-administrativnog-osoblja-profil.component.css']
})
export class ClanAdministrativnogOsobljaProfilComponent implements OnInit {

  formaZaDodavanjeNovogStudenta;
  studenti:Student[];
  registrovaniNesvrstaniKorisnici:RegistrovanKorisnik[];
  pretraga;//Property 'pretraga' does not exist on type 'ClanAdministrativnogOsobljaProfilComponent' samo zbog ovog errora stavljeno

  constructor(private service:StudentService, private service2:RegistrovanKorisnikService, private router:Router, private builder:FormBuilder) {
      this.formaZaDodavanjeNovogStudenta = builder.group({
        id:0,
        jmbg:"",
        brojIndeksa:"",
        mestoRodjenja: "",
        drzavaRodjenja: "",
        datumRodjenja: null,
        vanredni: null,
        godinaUpisa: null,
        korisnik: null,
        listaPredmeta: null

      }as Student);
  }

  ngOnInit(): void {
    this.dobaviStudente();
  }

  dobaviStudente(){
    this.service.dobavi().subscribe(data =>this.studenti = data);
    this.service2.dobavi().subscribe(data =>this.registrovaniNesvrstaniKorisnici = data);
    
  }

  dodajStudenta(data){

    let izabranKorisnik = null;

    for(let i = 0; i < this.registrovaniNesvrstaniKorisnici.length;i++){
        if(this.registrovaniNesvrstaniKorisnici[i].id == data.korisnik){
          izabranKorisnik = this.registrovaniNesvrstaniKorisnici[i];
        }
    }



    let novStudent = {id:0, 
          korisnik:izabranKorisnik,
          jmbg:data.jmbg,
          datumRodjenja:data.datumRodjenja,
          brojIndeksa:data.brojIndeksa,
          mestoRodjenja:data.mestoRodjenja,
          drzavaRodjenja:data.drzavaRodjenja,
          vanredni:data.vanredni,
          godinaUpisa:data.godinaUpisa};


    this.service.dodaj(novStudent).subscribe(data => this.dobaviStudente());
  }



}
