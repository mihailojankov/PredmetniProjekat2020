import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Nastavnik } from '../Models/nastavnik';
import { AbstractServiceService } from './abstract-service.service';

@Injectable({
  providedIn: 'root'
})
export class NastavnikService extends AbstractServiceService<Nastavnik> {

  

  constructor(public http:HttpClient) {
    super(http, "nastavnik");
  }

  



}
