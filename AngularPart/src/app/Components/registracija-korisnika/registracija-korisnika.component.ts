import { Component, OnInit } from '@angular/core';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { FormBuilder } from '@angular/forms';
import { RegistrovanKorisnik } from 'src/app/Models/registrovan-korisnik';
import { async } from '@angular/core/testing';

@Component({
  selector: 'app-registracija-korisnika',
  templateUrl: './registracija-korisnika.component.html',
  styleUrls: ['./registracija-korisnika.component.css']
})
export class RegistracijaKorisnikaComponent implements OnInit {

  //Registraciona forma
  regForm;
  response:number;

  constructor(
    private service:RegistrovanKorisnikService,
    private formBuilder:FormBuilder
  ) { 

    this.regForm = this.formBuilder.group({
      id:0,
      korisnickoIme:"",
      lozinka:"",
      email:"",
      ime:"",
      prezime:"",
      brojTelefona:"",
      adresa:""
    } as RegistrovanKorisnik);
  }

  ngOnInit(): void {
  }

  registruj(data){
    this.service.dodaj(data).subscribe(data => this.check(data));
     
  }

  //Neki lep ispis za uspesni ili neuspesnu registraciju
  check(response){
    
    if(response.status == 200){
      console.log("Uspesna registracija")
    }

    if(response.status == 409){
      console.log("Postojeci podaci");
    }
  }

}
