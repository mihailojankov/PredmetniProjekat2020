import { Component, OnInit } from '@angular/core';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { FormBuilder } from '@angular/forms';
import { RegistrovanKorisnik } from 'src/app/Models/registrovan-korisnik';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija-korisnika.component.html',
  styleUrls: ['./registracija-korisnika.component.css']
})
export class RegistracijaKorisnikaComponent implements OnInit {

  regForm;

  constructor(
    private service:RegistrovanKorisnikService,
    private formBuilder:FormBuilder,
    private router:Router
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
    this.service.registruj(data).subscribe(data => this.check(data));
  }

  //Neki lep ispis za uspesni ili neuspesnu registraciju
  check(response){
    console.log(response);

    if(response.status == 201){
      this.router.navigate(["/"]);
    }

    if(response.status == 409){
      window.alert("Postojeci podaci");
    }
  }

}
