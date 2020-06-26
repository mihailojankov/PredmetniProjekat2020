import { Injectable } from '@angular/core';
import {JwtHelperService} from '@auth0/angular-jwt';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Router} from '@angular/router';
import decode from 'jwt-decode';
import {Nastavnik} from '../Models/nastavnik';
import {Student} from '../Models/student';
import {ClanAdministrativnogOsoblja} from '../Models/clan-administrativnog-osoblja';
import {RegistrovanKorisnik} from '../Models/registrovan-korisnik';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public jwtHelperService: JwtHelperService = new JwtHelperService();


  constructor(public http: HttpClient, public router: Router) {

  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    if (token === undefined || token === null || token === '') {
      return false;
    }
    return !this.jwtHelperService.isTokenExpired(token);
  }


  public login(data){
    window.localStorage.setItem('token', '');

    const korisnik = {korisnickoIme: data.korisnickoIme, lozinka: data.lozinka};
    this.http.post<any>('http://localhost:8080/authenticate', korisnik).subscribe(data => {
      window.localStorage.setItem('token', data.jwt);
      this.router.navigate(['/']);

  });

  }

  public getCurrentUser() : Observable<any> {

      const token = window.localStorage.getItem('token');
      const payload = decode(token);

      const param = new HttpParams().set('username', payload.sub);

     return this.http.get<any>('http://localhost:8080/registrovanKorisnik/dobaviKorisnickePodatke', {params: param});
  }


  public getCurrentProfile(){
      const token = window.localStorage.getItem('token');
      const payload = decode(token);

      return payload.role;

  }

}
