import { Component, OnInit } from '@angular/core';
import { NastavnikService } from 'src/app/Services/nastavnik.service';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Nastavnik } from 'src/app/Models/nastavnik';
import { RegistrovanKorisnik } from 'src/app/Models/registrovan-korisnik';
import { ClanAdministrativnogOsoblja } from 'src/app/Models/clan-administrativnog-osoblja';
import { ClanAdministrativnogOsobljaService } from 'src/app/Services/clan-administrativnog-osoblja.service';

@Component({
  selector: 'app-admin-profil',
  templateUrl: './admin-profil.component.html',
  styleUrls: ['./admin-profil.component.css']
})
export class AdminProfilComponent implements OnInit {

  formaZaDodavanjeNastavnika;
  formaZaDodavanjeOsoblja;//
  nastavnici:Nastavnik[];
  osoblje:ClanAdministrativnogOsoblja[];//
  registrovaniNesvrstaniKorisnici:RegistrovanKorisnik[];
  showNastavnikForma = false;
  showOsobljeForma = false;
  public buttonName:any = 'Prikazi';
  public buttonNameO:any = 'Prikazi';

  constructor(private serviceN:NastavnikService, private serviceK:RegistrovanKorisnikService, private serviceO:ClanAdministrativnogOsobljaService,
    private router:Router, private builder:FormBuilder) {
      this.formaZaDodavanjeNastavnika = builder.group({
        id:0,
        biografija:"",
        jmbg:"",
        profesor:null,
        asistent:null,
        korisnik:null,
        predmeti:null
      } as Nastavnik);
      this.formaZaDodavanjeOsoblja = builder.group({
        id:0,
        jmbg:"",
        uloga:"",
        korisnik:null
      } as ClanAdministrativnogOsoblja);
    }

  ngOnInit(): void {
    this.dobaviKorisnike();
    this.dobaviNastavnike();
    this.dobaviOsoblje();
  }

  dobaviNastavnike(){
    this.serviceN.dobavi().subscribe(data => this.nastavnici = data);
  }
  dobaviKorisnike(){
    this.serviceK.dobavi().subscribe(data =>this.registrovaniNesvrstaniKorisnici = data);
  }

  dobaviOsoblje(){
    this.serviceO.dobavi().subscribe(data => this.osoblje = data);
  }



  //Za dodavanje nastavnika
  dodajNastavnika(data){
    let izabranKorisnik = null;

    for(let i = 0; i < this.registrovaniNesvrstaniKorisnici.length;i++){
      if(this.registrovaniNesvrstaniKorisnici[i].id == data.korisnik){
        izabranKorisnik = this.registrovaniNesvrstaniKorisnici[i];
      }
  }

  let novNastavnik = {
    id:0,
    jmbg:data.jmbg,
    biografija:data.biografija,
    profesor:data.profesor,
    asistent:data.asistent,
    korisnik:izabranKorisnik
  }
  this.serviceN.dodaj(novNastavnik).subscribe(data => this.dobaviNastavnike());

    
  }

  nastavnik(){
    this.showNastavnikForma = !this.showNastavnikForma;
    if(this.showNastavnikForma)  
    this.buttonName = "Sakrij";
  else
    this.buttonName = "Prikazi";
  }



  //Za dodavanje osoblja

  dodajOsoblje(data){
    let izabranKorisnik = null;

    for(let i = 0; i < this.registrovaniNesvrstaniKorisnici.length;i++){
      if(this.registrovaniNesvrstaniKorisnici[i].id == data.korisnik){
        izabranKorisnik = this.registrovaniNesvrstaniKorisnici[i];
      }
  }

  let novoOsoblje = {
    id:0,
    jmbg:data.jmbg,
    uloga:data.uloga,
    korisnik:izabranKorisnik
  }
  this.serviceO.dodaj(novoOsoblje).subscribe(data => this.dobaviOsoblje());
  }

  clan(){
    this.showOsobljeForma = !this.showOsobljeForma;
    if(this.showOsobljeForma)  
    this.buttonNameO = "Sakrij";
  else
    this.buttonNameO = "Prikazi";
  }
  



}
