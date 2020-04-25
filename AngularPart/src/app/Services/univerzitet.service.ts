import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Univerzitet } from '../Models/univerzitet';

@Injectable({
  providedIn: 'root'
})
export class UniverzitetService {

  adresaUniverzitet:string = "http://localhost:8080/univerzitet"

  constructor(public http:HttpClient) { }

  dobavi():Observable<Univerzitet[]>{
    return this.http.get<Univerzitet[]>(this.adresaUniverzitet);
  }
  dobaviPoId(id):Observable<Univerzitet>{
    return this.http.get<Univerzitet>(this.adresaUniverzitet + "/" + id);
  }

  dodaj(obj):Observable<Univerzitet>{
    return this.http.post<Univerzitet>(this.adresaUniverzitet, obj) ;
  }

  izmeni(obj):Observable<Univerzitet>{
    return this.http.put<Univerzitet>(this.adresaUniverzitet + "/" + obj.id, obj);
  }

  obrisi(id):Observable<Univerzitet>{
    return this.http.delete<Univerzitet>(this.adresaUniverzitet + "/" + id);
  }








}
