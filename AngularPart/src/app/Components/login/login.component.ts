import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import {RoleGuardService} from '../../Services/role-guard.service';
import {AuthService} from '../../Services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],

})
export class LoginComponent implements OnInit {

  loginForm;
  authority;

  constructor(public authService:AuthService, builder: FormBuilder) {
    this.loginForm = builder.group({
      korisnickoIme: '',
      lozinka: ''
    });
  }

  ngOnInit(): void {
    window.localStorage.setItem('token', '');
  }

  login(data) {
    this.authService.setCurrentUser(data);
  }






}
