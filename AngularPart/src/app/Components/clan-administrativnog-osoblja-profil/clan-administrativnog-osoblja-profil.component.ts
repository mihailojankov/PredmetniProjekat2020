import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/Services/student.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { Student } from 'src/app/Models/student';
import { RegistrovanKorisnik } from 'src/app/Models/registrovan-korisnik';
import { RokService } from 'src/app/Services/rok.service';
import { IspitService } from 'src/app/Services/ispit.service';
import { Rok } from 'src/app/Models/rok';
import { PrijavaIspita } from 'src/app/Models/prijava-ispita';
import { Ispit } from 'src/app/Models/ispit';
import { Predmet } from 'src/app/Models/predmet';
import { PredmetService } from 'src/app/Services/predmet.service';

@Component({
  selector: 'app-clan-administrativnog-osoblja-profil',
  templateUrl: './clan-administrativnog-osoblja-profil.component.html',
  styleUrls: ['./clan-administrativnog-osoblja-profil.component.css']
})
export class ClanAdministrativnogOsobljaProfilComponent implements OnInit {

  //Forme
  formaZaDodavanjeNovogStudenta;
  formaZaDodavanjeRoka;
  formaZaDodavanjeIspita;

  //Inicijalno prazne liste
  studenti:Student[];
  registrovaniNesvrstaniKorisnici:RegistrovanKorisnik[];
  predmeti:Predmet[];
  rokovi:Rok[];
  odabraniPredmetiZaStudenta:Predmet[] = [];

  //Polje za pretragu
  pretraga;

  //Slajdovi
  prikazIDodavanjeStudenata = false;
  prikazFormeRoka = false;
  prikazFormeIspita = false;


  //Za prikaz stranice u tabeli za studente
  p:number = 1;

  constructor(private service:StudentService, private service2:RegistrovanKorisnikService,private serviceRok:RokService,
    private serviceIspit:IspitService,private servicePredmet:PredmetService, private router:Router, private builder:FormBuilder) {
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
        listaPrijavaIspit:[]
      }as Rok);

      this.formaZaDodavanjeIspita = builder.group({
        id:0,
        datumVreme:null,
        predmet:null,
        listaPrijavaIspita:[],
        rok:null
      }as Ispit);
      
      
  }

  ngOnInit(): void {
    this.dobaviSve();
  }

  dobaviSve(){
    this.service.dobavi().subscribe(data =>this.studenti = data);
    this.service2.dobavi().subscribe(data =>this.registrovaniNesvrstaniKorisnici = data);
    this.servicePredmet.dobavi().subscribe(data =>this.predmeti = data);
    this.serviceRok.dobavi().subscribe(data => this.rokovi = data);
    
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
          godinaUpisa:data.godinaUpisa,
          listaPredmeta:this.odabraniPredmetiZaStudenta};

      console.log(this.odabraniPredmetiZaStudenta);
    this.service.dodaj(novStudent).subscribe(data => this.dobaviSve());
  }

  prikazIDodavanjeStudenataFunction(event){
    this.prikazIDodavanjeStudenata = !this.prikazIDodavanjeStudenata;
  }

  //Dodavanje izabranih predmeta u privremenu listu za studenta
  zakaciPredmetZaStudenta(data) {
    console.log(data);
    if (this.odabraniPredmetiZaStudenta.find(element => element == data) == undefined && data != '') {

      this.odabraniPredmetiZaStudenta.push(data);
    }
  }

  //Funkcija za dodavanje roka
  dodajRok(data){
    
    let novRok = {
      id:0,
      naziv:data.naziv,
      pocetak:data.pocetak,
      kraj:data.kraj,
      vanredan:data.vanredan,
      listaPrijavaIspit:[]
    };
    this.serviceRok.dodaj(novRok).subscribe(data => {
      window.alert("Uspesno ste dodali rok");
      this.dobaviSve();
    });
  }

  prikazFormeRokaFunction(event){
    this.prikazFormeRoka = !this.prikazFormeRoka;
  }


  //Funkcija za dodavanje ispita
  dodajIspit(data){

    let novIspit = {
      id:0,
      datumVreme:data.datumVreme,
      predmet:data.predmet,
      listaPrijavaIspita:[],
      rok:data.rok
    };

    this.serviceIspit.dodaj(novIspit).subscribe(data => {
      window.alert("Uspesno ste dodali ispit");
      this.dobaviSve();
    });
  }


  prikazFormeIspitaFunction(event){
    this.prikazFormeIspita = !this.prikazFormeIspita;
  }

}
