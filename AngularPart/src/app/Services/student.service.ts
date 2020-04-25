import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../Models/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  adresaStudent:string = "http://localhost:8080/student"

  constructor(public http:HttpClient) { }

  dobavi():Observable<Student[]>{
    return this.http.get<Student[]>(this.adresaStudent);
  }
  dobaviPoId(id):Observable<Student>{
    return this.http.get<Student>(this.adresaStudent + "/" + id);
  }

  dodaj(obj):Observable<Student>{
    return this.http.post<Student>(this.adresaStudent, obj) ;
  }

  izmeni(obj):Observable<Student>{
    return this.http.put<Student>(this.adresaStudent + "/" + obj.id, obj);
  }

  obrisi(id):Observable<Student>{
    return this.http.delete<Student>(this.adresaStudent + "/" + id);
  }



}
