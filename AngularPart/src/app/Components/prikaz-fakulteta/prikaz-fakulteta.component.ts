import { Component, OnInit, Output } from '@angular/core';
import { Fakultet } from 'src/app/Models/fakultet';
import { FakultetService } from 'src/app/Services/fakultet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-prikaz-fakulteta',
  templateUrl: './prikaz-fakulteta.component.html',
  styleUrls: ['./prikaz-fakulteta.component.css']
})
export class PrikazFakultetaComponent implements OnInit {

  fakulteti:Fakultet[];
  public izabranFakultet:Fakultet;


  constructor(private service:FakultetService, private router:Router) { }

  ngOnInit(): void {
      this.dobaviSve();
  }

  dobaviSve(){
    this.service.dobavi().subscribe(data => this.fakulteti = data);
  }



}
