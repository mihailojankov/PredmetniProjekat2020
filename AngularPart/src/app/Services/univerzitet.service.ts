import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Univerzitet } from '../Models/univerzitet';
import { AbstractServiceService } from './abstract-service.service';

@Injectable({
  providedIn: 'root'
})
export class UniverzitetService extends AbstractServiceService<Univerzitet> {

  constructor(public http:HttpClient) {
    super(http, "univerzitet");
  }

  

  








}
