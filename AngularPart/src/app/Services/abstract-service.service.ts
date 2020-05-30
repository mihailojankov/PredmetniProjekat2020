import { Injectable, Type } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



export class AbstractServiceService <D>{

  adresaD:string;
  


  constructor(public http:HttpClient, public deoAdresa:string) { 

    this.adresaD = "http://localhost:8080/" + this.deoAdresa;
  }

  dobavi():Observable<D[]>{
    return this.http.get<D[]>(this.adresaD);
  }
  dobaviPoId(id):Observable<D>{
    return this.http.get<D>(this.adresaD + "/" + id);
  }

  dodaj(obj):Observable<D>{
    return this.http.post<D>(this.adresaD, obj) ;
  }

  izmeni(obj):Observable<D>{
    return this.http.put<D>(this.adresaD + "/" + obj.id, obj);
  }

  obrisi(id):Observable<D>{
    return this.http.delete<D>(this.adresaD + "/" + id);
  }
}
