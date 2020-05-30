import { Injectable } from '@angular/core';
import { AbstractServiceService } from './abstract-service.service';
import { PrijavaIspita } from '../Models/prijava-ispita';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PrijavaIspitaService extends AbstractServiceService<PrijavaIspita> {

  constructor(public http:HttpClient) {
    super(http, "prijavaIspita");
   }
}
