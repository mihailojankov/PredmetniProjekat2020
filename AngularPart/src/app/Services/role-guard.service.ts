import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';
import {AuthService} from './auth.service';
import decode from 'jwt-decode';


@Injectable({
  providedIn: 'root'
})
export class RoleGuardService implements CanActivate {

  constructor(public auth: AuthService, public router: Router) { }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRole = route.data.expectedRole;

    const token = localStorage.getItem('token');

    if(token === null || token === undefined || token === ""){
      this.router.navigate(['login']);
      return false;
    }
    const payload = decode(token);

    console.log(typeof payload.role, typeof expectedRole);
    if (!this.auth.isAuthenticated() || payload.role !== expectedRole) {
      this.router.navigate(['login']);
      return false;
    }


    return true;

  }
}
