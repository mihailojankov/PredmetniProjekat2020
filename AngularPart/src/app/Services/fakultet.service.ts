import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fakultet } from '../Models/fakultet';
import { AbstractServiceService } from './abstract-service.service';


@Injectable({
  providedIn: 'root'
})
export class FakultetService extends AbstractServiceService<Fakultet> {
  
  

  constructor(public http:HttpClient) {
    super(http,"fakultet");
  }

 





}
