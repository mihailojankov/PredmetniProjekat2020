import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistrovanKorisnik } from '../Models/registrovan-korisnik';
import { AbstractServiceService } from './abstract-service.service';

@Injectable({
  providedIn: 'root'
})
export class RegistrovanKorisnikService extends AbstractServiceService<RegistrovanKorisnik> {


  constructor(public http:HttpClient) {
    super(http, "registrovanKorisnik");
   }

  



}
