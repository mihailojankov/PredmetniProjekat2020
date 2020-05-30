import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../Models/student';
import { AbstractServiceService } from './abstract-service.service';

@Injectable({
  providedIn: 'root'
})
export class StudentService extends AbstractServiceService<Student> {


  constructor(public http:HttpClient) {
    super(http, "student");
   }

  



}
