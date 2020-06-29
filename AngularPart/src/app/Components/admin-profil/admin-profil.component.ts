import { Component, OnInit } from '@angular/core';
import { NastavnikService } from 'src/app/Services/nastavnik.service';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Nastavnik } from 'src/app/Models/nastavnik';
import { RegistrovanKorisnik } from 'src/app/Models/registrovan-korisnik';
import { ClanAdministrativnogOsoblja } from 'src/app/Models/clan-administrativnog-osoblja';
import { ClanAdministrativnogOsobljaService } from 'src/app/Services/clan-administrativnog-osoblja.service';
import { PredmetService } from 'src/app/Services/predmet.service';
import { Predmet } from 'src/app/Models/predmet';
import { SmerFakulteta } from 'src/app/Models/smer-fakulteta';
import { SmerFakultetaService } from 'src/app/Services/smer-fakulteta.service';
import { FakultetService } from 'src/app/Services/fakultet.service';
import { Fakultet } from 'src/app/Models/fakultet';




@Component({
  selector: 'app-admin-profil',
  templateUrl: './admin-profil.component.html',
  styleUrls: ['./admin-profil.component.css']
})
export class AdminProfilComponent implements OnInit {

  pretraga;

  // Forme za dodavanje
  formaZaDodavanjeNastavnika;
  formaZaDodavanjeOsoblja;
  formaZaDodavanjePredmeta;
  formaZaDodavanjeSmera;
  formaZaDodavanjeFakulteta;

  // Prazne inicijalne liste
  nastavnici: Nastavnik[];
  osoblje: ClanAdministrativnogOsoblja[];
  registrovaniNesvrstaniKorisnici: RegistrovanKorisnik[];
  predmeti: Predmet[];
  odabraniPredmetiZaSmer: Predmet[] = [];
  fakulteti: Fakultet[];

  // Modeli za prikaz
  showNastavnikForma = false;
  showOsobljeForma = false;
  showPredmetForma = false;
  showSmerForma = false;
  showFakultetForma = false;
  showTabelaOsoblje = false;


 
  constructor(private serviceN: NastavnikService, private serviceK: RegistrovanKorisnikService,
              private serviceO: ClanAdministrativnogOsobljaService,
              private servicePredmet: PredmetService, private serviceSmer: SmerFakultetaService,
              private serviceFakultet: FakultetService, private router: Router, private builder: FormBuilder) {
      this.formaZaDodavanjeNastavnika = builder.group({
        id: 0,
        biografija: '',
        jmbg: '',
        profesor: false,
        asistent: false,
        korisnik: null,
        predmeti: [],
        izborTipaNastavnika: ''
      } as Nastavnik);

      this.formaZaDodavanjeOsoblja = builder.group({
        id: 0,
        jmbg: '',
        uloga: '',
        korisnik: null
      } as ClanAdministrativnogOsoblja);

      this.formaZaDodavanjePredmeta = builder.group({
        id: 0,
        naziv: '',
        espb: 0,
        obavezan: true,
        brojPredavanja: 15,
        brojVezbi: 15,
        godinaStudija: 0,
        semestar: 0,
        silabus: ''
      }as Predmet);

      this.formaZaDodavanjeSmera = builder.group({
        id: 0,
        naziv: '',
        opis: '',
        predmeti: [],
        fakultet: null

      } as SmerFakulteta);

      this.formaZaDodavanjeFakulteta = builder.group({
        id: 0,
        naziv: '',
        adresa: '',
        mesto: '',
        opis: '',
        smerovi: []
      } as Fakultet);

    }

  ngOnInit(): void {
    this.dobaviSve();
  }

  dobaviSve() {
    this.serviceN.dobavi().subscribe(data => this.nastavnici = data);
    this.serviceK.dobavi().subscribe(data => this.registrovaniNesvrstaniKorisnici = data);
    this.serviceO.dobavi().subscribe(data => {
      this.osoblje = data;
    });
    this.servicePredmet.dobavi().subscribe(data => this.predmeti = data);
    this.serviceFakultet.dobavi().subscribe(data => this.fakulteti = data);
  }


  // Za dodavanje nastavnika
  dodajNastavnika(data) {


    if (data.izborTipaNastavnika == 'profesor') {
      data.profesor = true;
    }
    if (data.izborTipaNastavnika == 'asistent') {
      data.asistent = true;
    }
    const novNastavnik = {
      id: 0,
      jmbg: data.jmbg,
      biografija: data.biografija,
      profesor: data.profesor,
      asistent: data.asistent,
      korisnik: data.korisnik
    };

    this.serviceN.dodaj(novNastavnik).subscribe(data => this.dobaviSve());


  }

  // Promena vrednosti prikaza forme nastavnika
  showNastavnikFormaFunction(event) {
    this.showNastavnikForma = !this.showNastavnikForma;
  }


  // Za dodavanje osoblja
  dodajOsoblje(data) {

    const novoOsoblje = {
      id: 0,
      jmbg: data.jmbg,
      uloga: data.uloga,
      korisnik: data.korisnik
    };

    this.serviceO.dodaj(novoOsoblje).subscribe(data => this.dobaviSve());
  }

  // Promena vrednosti prikaza forme osoblja
  showOsobljeFormaFunction(event) {
    this.showOsobljeForma = !this.showOsobljeForma;
  }


  // Funkcija za dodavanje predmeta
  dodajPredmet(data) {

    const noviPredmet = {
      id: 0,
      naziv: data.naziv,
      espb: data.espb,
      obavezan: data.obavezan,
      brojPredavanja: data.brojPredavanja,
      brojVezbi: data.brojVezbi,
      godinaStudija: data.godinaStudija,
      semestar: data.semestar,
      silabus: data.silabus
    };

    this.servicePredmet.dodaj(noviPredmet).subscribe(data => {
      window.alert('Uspesno ste dodali predmet');
    });
  }

  // Promena vrednosti prikaza forme predmeta
  showPredmetFormaFunction(event) {
    this.showPredmetForma = !this.showPredmetForma;
  }


  // Funkcija za dodavanje smera fakulteta
  dodajSmer(data) {

    const noviSmer = {
      id: 0,
      naziv: data.naziv,
      opis: data.opis,
      predmeti: this.odabraniPredmetiZaSmer,
      fakultet: data.fakultet
    };

    this.serviceSmer.dodaj(noviSmer).subscribe(data => {
      window.alert('Uspesno ste dodali smer');
    });
  }

  // Promena vrednosti prikaza forme smera fakulteta
  showSmerFormaFunction(event) {
    this.showSmerForma = !this.showSmerForma;
  }


  // Dodavanje selektovanih predmeta u privremenu listu pre dodavanja smera
  zakaciPredmetNaSmer(data) {
    console.log(data);
    if (this.odabraniPredmetiZaSmer.find(element => element == data) == undefined && data != '') {

      this.odabraniPredmetiZaSmer.push(data);
    }
  }


  // Funkcija za dodavanje fakulteta
  dodajFakultet(data) {

    const novFakultet = {id: 0,
    naziv: data.naziv,
    adresa: data.adresa,
    mesto: data.mesto,
    opis: data.opis,
    smerovi: []
  };
    this.serviceFakultet.dodaj(novFakultet).subscribe(data => {
    window.alert('Dodali ste novi fakultet');
  });
  }


  // Promena vrednosti prikaza forme fakulteta
  showFakultetFormaFunction(event) {
    this.showFakultetForma = !this.showFakultetForma;
  }

  //Brisanje clana administrativnog osoblja
  obrisi(id){
    this.serviceO.obrisi(id).subscribe(data => this.dobaviSve());
  }
  showTabelaOsobljeFunction(event) {
    this.showTabelaOsoblje = !this.showTabelaOsoblje;
  }






}
