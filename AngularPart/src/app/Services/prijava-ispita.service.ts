import { Injectable } from '@angular/core';
import { AbstractServiceService } from './abstract-service.service';
import { PrijavaIspita } from '../Models/prijava-ispita';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class PrijavaIspitaService extends AbstractServiceService<PrijavaIspita> {

  constructor(public http:HttpClient) {
    super(http, "prijavaIspita");
   }


   nadjiPrijavePoIdStudenta(id) :Observable<PrijavaIspita[]>{
     return this.http.get<PrijavaIspita[]>(this.adresaD + "/nadjiPoIdStudenta/" + id);
   }
}
