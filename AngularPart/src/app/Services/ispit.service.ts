import { Injectable } from '@angular/core';
import { AbstractServiceService } from './abstract-service.service';
import { Ispit } from '../Models/ispit';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IspitService extends AbstractServiceService<Ispit> {

  constructor(public http:HttpClient) {
    super(http,"ispit");
   }
}
