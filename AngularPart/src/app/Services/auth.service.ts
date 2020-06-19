import { Injectable } from '@angular/core';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(public jwtHelperService: JwtHelperService) {
  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    if (token === undefined || token === null || token === '') {
      return false;
    }
    return !this.jwtHelperService.isTokenExpired(token);
  }

  // Dodaj decode
  // Dodaj dobavljanje po id



}
