import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Predmet } from '../Models/predmet';

@Injectable({
  providedIn: 'root'
})
export class PredmetService {

  adresaPredmet:string = "http://localhost:8080/predmet"

  constructor(public http:HttpClient) { }

  dobavi():Observable<Predmet[]>{
    return this.http.get<Predmet[]>(this.adresaPredmet);
  }
  dobaviPoId(id):Observable<Predmet>{
    return this.http.get<Predmet>(this.adresaPredmet + "/" + id);
  }

  dodaj(obj):Observable<Predmet>{
    return this.http.post<Predmet>(this.adresaPredmet, obj) ;
  }

  izmeni(obj):Observable<Predmet>{
    return this.http.put<Predmet>(this.adresaPredmet + "/" + obj.id, obj);
  }

  obrisi(id):Observable<Predmet>{
    return this.http.delete<Predmet>(this.adresaPredmet + "/" + id);
  }




}
