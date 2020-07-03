import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LMS';
  links = [{name: 'Pocetna', link: ''}, {name: 'Prijava', link: '/login'}, {name: 'Registracija', link: '/registracija'}];
  activeLink = 'login';
  constructor(public router: Router) {}
}
