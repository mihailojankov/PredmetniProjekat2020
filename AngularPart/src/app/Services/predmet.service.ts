import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Predmet } from '../Models/predmet';
import { AbstractServiceService } from './abstract-service.service';

@Injectable({
  providedIn: 'root'
})
export class PredmetService extends AbstractServiceService<Predmet> {

  constructor(public http:HttpClient) {
    super(http, "predmet");
  }

  

  dobaviPoIdSmera(id):Observable<Predmet[]>{
    return this.http.get<Predmet[]>(this.adresaD + "/pronadjiPoSmeru/" + id);
  }



}
