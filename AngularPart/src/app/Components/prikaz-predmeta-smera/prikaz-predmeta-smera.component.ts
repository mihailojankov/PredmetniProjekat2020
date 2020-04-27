import { Component, OnInit } from '@angular/core';
import { Predmet } from 'src/app/Models/predmet';
import { Observable } from 'rxjs';
import { PredmetService } from 'src/app/Services/predmet.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-prikaz-predmeta-smera',
  templateUrl: './prikaz-predmeta-smera.component.html',
  styleUrls: ['./prikaz-predmeta-smera.component.css']
})
export class PrikazPredmetaSmeraComponent implements OnInit {

  predmeti$:Observable<Predmet[]>;
  nazivSmera:string;

  constructor(private service:PredmetService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.predmeti$ = this.service.dobaviPoIdSmera(this.route.snapshot.queryParams["id"]);
    this.nazivSmera = this.route.snapshot.queryParams["naziv"];
  }

}
