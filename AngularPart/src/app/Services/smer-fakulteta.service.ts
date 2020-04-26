import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SmerFakulteta } from '../Models/smer-fakulteta';

@Injectable({
  providedIn: 'root'
})
export class SmerFakultetaService {

  adresaSmerFakulteta:string = "http://localhost:8080/smerFakulteta"

  constructor(public http:HttpClient) { }

  dobavi():Observable<SmerFakulteta[]>{
    return this.http.get<SmerFakulteta[]>(this.adresaSmerFakulteta);
  }
  dobaviPoId(id):Observable<SmerFakulteta>{
    return this.http.get<SmerFakulteta>(this.adresaSmerFakulteta + "/" + id);
  }

  dodaj(obj):Observable<SmerFakulteta>{
    return this.http.post<SmerFakulteta>(this.adresaSmerFakulteta, obj) ;
  }

  izmeni(obj):Observable<SmerFakulteta>{
    return this.http.put<SmerFakulteta>(this.adresaSmerFakulteta + "/" + obj.id, obj);
  }

  obrisi(id):Observable<SmerFakulteta>{
    return this.http.delete<SmerFakulteta>(this.adresaSmerFakulteta + "/" + id);
  }

  dobaviPoIdFakulteta(id):Observable<SmerFakulteta[]>{
    return this.http.get<SmerFakulteta[]>(this.adresaSmerFakulteta + "/pronadjiSmeroveFakulteta/" + id);
  }





}
