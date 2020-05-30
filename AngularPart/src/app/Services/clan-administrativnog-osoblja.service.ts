import { Injectable } from '@angular/core';
import { AbstractServiceService } from './abstract-service.service';
import { ClanAdministrativnogOsoblja } from '../Models/clan-administrativnog-osoblja';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClanAdministrativnogOsobljaService extends AbstractServiceService<ClanAdministrativnogOsoblja> {

  constructor(public http:HttpClient) {
    super(http,"clanAdministrativnogOsoblja");
  }
}
