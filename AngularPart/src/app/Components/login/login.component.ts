import { Component, OnInit } from '@angular/core';
import { RegistrovanKorisnikService } from 'src/app/Services/registrovan-korisnik.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  korisnickoIme:string = "";
  lozinka:string = "";

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  login(){
    if(this.korisnickoIme == "" || this.lozinka == ""){
      return;
    }
    let korisnik = {korisnickoIme:this.korisnickoIme, lozinka:this.lozinka};
    this.http.post<any>("http://localhost:8080/authenticate", korisnik, {observe:'response'}).subscribe(data => {
      console.log(data);
      if(typeof data != 'string'){
        window.alert("Pogresni podaci");
      }

    });

  }
  

}
