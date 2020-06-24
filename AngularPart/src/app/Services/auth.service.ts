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

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  currentToken;
  currentUser;
  profilePage;

  public jwtHelperService: JwtHelperService = new JwtHelperService();


  constructor(public http: HttpClient, public router: Router) {

  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    if (token === undefined || token === null || token === '') {
      return false;
    }
    this.currentToken = token;

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

  public setCurrentUser() {

      const token = window.localStorage.getItem('token');
      const payload = decode(token);

      const param = new HttpParams().set('username', payload.sub);

      if (payload.role === 'ADMIN') {
        this.profilePage = 'adminProfil';
        return;
      }

      this.http.get<any>('http://localhost:8080/registrovanKorisnik/dobaviKorisnickePodatke', {params: param}).subscribe(data => {

          if (payload.role === 'NASTAVNIK') {
            this.currentUser = data;
            this.profilePage = 'nastavnikProfil';
          }

          if (payload.role === 'STUDENT') {
            this.currentUser = data;
            this.profilePage = 'studentProfil';
          }

          if (payload.role === 'CLAN') {
            this.currentUser = data;
            this.profilePage = 'clanAdministrativnogOsobljaProfil';
          } else {

            this.currentUser = data;
            this.profilePage = 'korisnikProfil';
          }
      });


  }

  public getCurrentUser() {
    return this.currentUser;
  }

  public getCurrentProfilePage() {
    return this.getCurrentProfilePage();
  }



}
