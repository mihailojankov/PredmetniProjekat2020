import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistrovanKorisnik } from '../Models/registrovan-korisnik';

@Injectable({
  providedIn: 'root'
})
export class RegistrovanKorisnikService {

  adresaRegistrovanKorisnik:string = "http://localhost:3000/registrovanKorisnik"

  constructor(public http:HttpClient) { }

  dobavi():Observable<RegistrovanKorisnik[]>{
    return this.http.get<RegistrovanKorisnik[]>(this.adresaRegistrovanKorisnik);
  }
  dobaviPoId(id):Observable<RegistrovanKorisnik>{
    return this.http.get<RegistrovanKorisnik>(this.adresaRegistrovanKorisnik + "/" + id);
  }

  dodaj(obj):Observable<RegistrovanKorisnik>{
    return this.http.post<RegistrovanKorisnik>(this.adresaRegistrovanKorisnik + "/", obj) ;
  }

  izmeni(obj):Observable<RegistrovanKorisnik>{
    return this.http.put<RegistrovanKorisnik>(this.adresaRegistrovanKorisnik + "/" + obj.id, obj);
  }

  obrisi(id):Observable<RegistrovanKorisnik>{
    return this.http.delete<RegistrovanKorisnik>(this.adresaRegistrovanKorisnik + "/" + id);
  }



}
