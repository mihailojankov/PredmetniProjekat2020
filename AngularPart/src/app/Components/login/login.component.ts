import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  
})
export class LoginComponent implements OnInit {

  korisnickoIme:string = "";
  lozinka:string = "";
  ulogovan = false;
  authority:string;

  constructor(private http:HttpClient, private router:Router) { }

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
    window.localStorage.removeItem("token");
    
    let korisnik = {korisnickoIme:this.korisnickoIme, lozinka:this.lozinka};
    this.http.post<any>("http://localhost:8080/authenticate", korisnik).subscribe(data => {

        window.localStorage.setItem("token", data.jwt);
        this.ulogovan = true;

        let payload = JSON.parse(atob(data.jwt.split('.')[1]));
        this.authority = payload.role;
    });
  }

  logout(){
      window.localStorage.setItem("token", "");
      this.ulogovan = false;
  }
  
  chooseProfile(){
    console.log(this.authority);
      if(this.authority == "CLAN"){
        this.router.navigate(["clanAdministrativnogOsobljaProfil"]);
      }
      if(this.authority == "NASTAVNIK"){
        this.router.navigate(["nastavnikProfil"]);
      }
      if(this.authority == "STUDENT"){
        this.router.navigate(["studentProfil"]);
      }
      if(this.authority == "ADMIN"){
        this.router.navigate(["adminProfil"])
      }
      
  }



  

}
