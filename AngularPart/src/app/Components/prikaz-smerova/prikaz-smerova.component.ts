import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Fakultet } from 'src/app/Models/fakultet';
import { FakultetService } from 'src/app/Services/fakultet.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-prikaz-smerova',
  templateUrl: './prikaz-smerova.component.html',
  styleUrls: ['./prikaz-smerova.component.css']
})
export class PrikazSmerovaComponent implements OnInit {

  @Input()
  fakultet:Fakultet;

  constructor(private service:FakultetService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    
  }

}
