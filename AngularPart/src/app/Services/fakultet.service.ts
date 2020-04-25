import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fakultet } from '../Models/fakultet';


@Injectable({
  providedIn: 'root'
})
export class FakultetService {
  
  adresaFakultet:string = "http://localhost:8080/fakultet"

  constructor(public http:HttpClient) { }

  dobavi():Observable<Fakultet[]>{
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
