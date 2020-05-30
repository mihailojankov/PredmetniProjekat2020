import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SmerFakulteta } from '../Models/smer-fakulteta';
import { AbstractServiceService } from './abstract-service.service';

@Injectable({
  providedIn: 'root'
})
export class SmerFakultetaService extends AbstractServiceService<SmerFakulteta> {


  constructor(public http:HttpClient) {
    super(http, "smerFakulteta");
   }

  

  dobaviPoIdFakulteta(id):Observable<SmerFakulteta[]>{
    return this.http.get<SmerFakulteta[]>(this.adresaD + "/pronadjiSmeroveFakulteta/" + id);
  }





}
