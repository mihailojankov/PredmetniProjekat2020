import { Injectable } from '@angular/core';
import { AbstractServiceService } from './abstract-service.service';
import { Rok } from '../Models/rok';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RokService extends AbstractServiceService<Rok> {

  constructor(public http:HttpClient) {
    super(http,"rok");
   }
}
