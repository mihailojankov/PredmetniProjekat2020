import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Nastavnik } from '../Models/nastavnik';

@Injectable({
  providedIn: 'root'
})
export class NastavnikService {

  adresaNastavnik:string = "http://localhost:3000/nastavnik"

  constructor(public http:HttpClient) { }

  dobavi():Observable<Nastavnik[]>{
    return this.http.get<Nastavnik[]>(this.adresaNastavnik);
  }
  dobaviPoId(id):Observable<Nastavnik>{
    return this.http.get<Nastavnik>(this.adresaNastavnik + "/" + id);
  }

  dodaj(obj):Observable<Nastavnik>{
    return this.http.post<Nastavnik>(this.adresaNastavnik + "/", obj) ;
  }

  izmeni(obj):Observable<Nastavnik>{
    return this.http.put<Nastavnik>(this.adresaNastavnik + "/" + obj.id, obj);
  }

  obrisi(id):Observable<Nastavnik>{
    return this.http.delete<Nastavnik>(this.adresaNastavnik + "/" + id);
  }



}
