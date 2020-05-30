import { Injectable } from '@angular/core';
import { AbstractServiceService } from './abstract-service.service';
import { IshodIspita } from '../Models/ishod-ispita';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IshodIspitaService extends AbstractServiceService<IshodIspita> {

  constructor(public http:HttpClient) {
    super(http,"ishodIspita");
   }
}
