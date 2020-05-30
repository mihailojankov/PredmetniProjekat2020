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
  ulogovan = false;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
   /**  if(window.localStorage.getItem("token") != ""){
      this.ulogovan = true;
    }
    */
  }



  login(){
    if(this.korisnickoIme == "" || this.lozinka == ""){
      return;
    }
    let korisnik = {korisnickoIme:this.korisnickoIme, lozinka:this.lozinka};
    this.http.post<any>("http://localhost:8080/authenticate", korisnik).subscribe(data => {

        window.localStorage.setItem("token", data.jwt);
        this.ulogovan = true;
    });
  }

  logout(){
      window.localStorage.setItem("token", "");
      this.ulogovan = false;
  }



  

}
