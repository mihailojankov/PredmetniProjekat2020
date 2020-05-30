import { Component, OnInit } from '@angular/core';
import { Predmet } from 'src/app/Models/predmet';
import { Observable } from 'rxjs';
import { PredmetService } from 'src/app/Services/predmet.service';
import { Router, ActivatedRoute } from '@angular/router';
import { SmerFakulteta } from 'src/app/Models/smer-fakulteta';
import { SmerFakultetaService } from 'src/app/Services/smer-fakulteta.service';

@Component({
  selector: 'app-prikaz-predmeta-smera',
  templateUrl: './prikaz-predmeta-smera.component.html',
  styleUrls: ['./prikaz-predmeta-smera.component.css']
})
export class PrikazPredmetaSmeraComponent implements OnInit {

  smer:SmerFakulteta;

  constructor(private service:SmerFakultetaService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.dobaviSmer();
  }

  dobaviSmer(){
    this.service.dobaviPoId(this.route.snapshot.queryParams["id"]).subscribe(data => {
      this.smer = data;
    });
  }

}
