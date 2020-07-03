import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../Services/auth.service';

@Component({
  selector: 'app-pocetna',
  templateUrl: './pocetna.component.html',
  styleUrls: ['./pocetna.component.css']
})
export class PocetnaComponent implements OnInit {

  role = "";

  constructor(private serviceAuth: AuthService) { }

  ngOnInit(): void {
      this.role = this.serviceAuth.getCurrentProfile();
  }



}
