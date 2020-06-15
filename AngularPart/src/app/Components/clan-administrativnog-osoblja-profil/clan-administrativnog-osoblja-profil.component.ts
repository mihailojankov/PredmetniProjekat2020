import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/Services/student.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { Student } from 'src/app/Models/student';
import { RegistrovanKorisnik } from 'src/app/Models/registrovan-korisnik';
import { RokService } from 'src/app/Services/rok.service';

@Component({
  selector: 'app-clan-administrativnog-osoblja-profil',
  templateUrl: './clan-administrativnog-osoblja-profil.component.html',
  styleUrls: ['./clan-administrativnog-osoblja-profil.component.css']
})
export class ClanAdministrativnogOsobljaProfilComponent implements OnInit {

  //Forme
  formaZaDodavanjeNovogStudenta;
  formaZaDodavanjeRoka;

  //Inicijalno prazne liste
  studenti:Student[];
  registrovaniNesvrstaniKorisnici:RegistrovanKorisnik[];

  //Polje za pretragu
  pretraga;

  //Slajdovi
  prikazIDodavanjeStudenata = false;
  prikazFormeRoka = false;

  constructor(private service:StudentService, private service2:RegistrovanKorisnikService,private serviceRok:RokService, private router:Router, private builder:FormBuilder) {
      this.formaZaDodavanjeNovogStudenta = builder.group({
        id:0,
        jmbg:"",
        brojIndeksa:"",
        mestoRodjenja: "",
        drzavaRodjenja: "",
        datumRodjenja: null,
        vanredni: false,
        godinaUpisa: "",
        korisnik: null,
        listaPredmeta: []

      }as Student);

      this.formaZaDodavanjeRoka = builder.group({
        id:0,
        naziv:"",
        pocetak:null,
        kraj:null,
        vanredan:false,
        listaPrijavaIspita:[]
      })
  }

  ngOnInit(): void {
    this.dobaviStudente();
  }

  dobaviStudente(){
    this.service.dobavi().subscribe(data =>this.studenti = data);
    this.service2.dobavi().subscribe(data =>this.registrovaniNesvrstaniKorisnici = data);
    
  }


  //Funkcija za dodavanje studenta
  dodajStudenta(data){

    let novStudent = {id:0, 
          korisnik:data.korisnik,
          jmbg:data.jmbg,
          datumRodjenja:data.datumRodjenja,
          brojIndeksa:data.brojIndeksa,
          mestoRodjenja:data.mestoRodjenja,
          drzavaRodjenja:data.drzavaRodjenja,
          vanredni:data.vanredni,
          godinaUpisa:data.godinaUpisa};


    this.service.dodaj(novStudent).subscribe(data => this.dobaviStudente());
  }

  prikazIDodavanjeStudenataFunction(event){
    this.prikazIDodavanjeStudenata = !this.prikazIDodavanjeStudenata;
  }

  //Funkcija za dodavanje roka
  dodajRok(data){
    
    let novRok = {
      id:0,
      naziv:data.naziv,
      pocetak:data.pocetak,
      kraj:data.kraj,
      vanredan:data.vanredan,
      listaPrijavaIspita:[]
    };
    this.serviceRok.dodaj(novRok).subscribe(data => {
      window.alert("Uspesno ste dodali rok");
    });
  }

  prikazFormeRokaFunction(event){
    this.prikazFormeRoka = !this.prikazFormeRoka;
  }





}
