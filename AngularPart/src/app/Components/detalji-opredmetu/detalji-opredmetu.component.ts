import { Component, OnInit } from '@angular/core';
import { Predmet } from 'src/app/Models/predmet';
import { Observable } from 'rxjs';
import { PredmetService } from 'src/app/Services/predmet.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Nastavnik } from 'src/app/Models/nastavnik';

@Component({
  selector: 'app-detalji-opredmetu',
  templateUrl: './detalji-opredmetu.component.html',
  styleUrls: ['./detalji-opredmetu.component.css']
})
export class DetaljiOPredmetuComponent implements OnInit {

  predmet:Predmet;
  asistent:Nastavnik;
  profesor:Nastavnik;

  constructor(private service:PredmetService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
      this.service.dobaviPoId(this.route.snapshot.queryParams["id"]).subscribe(data => this.napraviKomponentu(data));
  }

  napraviKomponentu(predmet:Predmet){
      this.profesor = predmet.listaNastavnika.find(x => x.profesor === true);
      this.asistent = predmet.listaNastavnika.find(x => x.asistent === true);
      this.predmet = predmet;
  }



}
