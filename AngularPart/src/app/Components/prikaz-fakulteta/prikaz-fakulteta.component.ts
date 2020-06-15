import { Component, OnInit, Output, Input } from '@angular/core';
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
  @Input()
  izabranFakultet;


  constructor(private service:FakultetService, private router:Router) { }

  ngOnInit(): void {
      this.dobaviSve();
      this.izabranFakultet = undefined;
  }

  dobaviSve(){
    this.service.dobavi().subscribe(data => this.fakulteti = data);
  }

  izaberiFakultet(fakultet:Fakultet){
    this.izabranFakultet = fakultet;
  }



}
