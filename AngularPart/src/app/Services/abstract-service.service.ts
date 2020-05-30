import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AbstractServiceService{

  
  klasa:<D>  ;
  deoAdresa:adresaDeo;

  adresaFakultet:string = "http://localhost:8080/" + this.deoAdresa;


  constructor(public http:HttpClient) { }

  dobavi():Observable<this.klasa[]>{
    return this.http.get<Fakultet[]>(this.adresaFakultet);
  }
  dobaviPoId(id):Observable<Fakultet>{
    return this.http.get<Fakultet>(this.adresaFakultet + "/" + id);
  }

  dodaj(obj):Observable<Fakultet>{
    return this.http.post<Fakultet>(this.adresaFakultet, obj) ;
  }

  izmeni(obj):Observable<Fakultet>{
    return this.http.put<Fakultet>(this.adresaFakultet + "/" + obj.id, obj);
  }

  obrisi(id):Observable<Fakultet>{
    return this.http.delete<Fakultet>(this.adresaFakultet + "/" + id);
  }
}
