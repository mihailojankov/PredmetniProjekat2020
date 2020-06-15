import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  
})
export class LoginComponent implements OnInit {

  loginForm;
  authority;

  constructor(private http:HttpClient, private router:Router, builder:FormBuilder) {
    this.loginForm = builder.group({
      korisnickoIme:"",
      lozinka:""
    });
  }

  ngOnInit(): void {
    window.localStorage.setItem("token", "");
  }

  login(data){
    window.localStorage.setItem("token", "");
    
    let korisnik = {korisnickoIme:data.korisnickoIme, lozinka:data.lozinka};
    this.http.post<any>("http://localhost:8080/authenticate", korisnik).subscribe(data => {
      window.localStorage.setItem("token", data.jwt);
      this.router.navigate(["/"]);
        
    });
  }

  
  chooseProfile(){
    let payload = JSON.parse(atob(window.localStorage.getItem("token").split('.')[1]));
    let authority = payload.role;


      if(authority == "CLAN"){
        this.router.navigate(["clanAdministrativnogOsobljaProfil"]);
      }
      if(authority == "NASTAVNIK"){
        this.router.navigate(["nastavnikProfil"]);
      }
      if(authority == "STUDENT"){
        this.router.navigate(["studentProfil"]);
      }
      if(authority == "ADMIN"){
        this.router.navigate(["adminProfil"])
      }
      
  }



  

}
