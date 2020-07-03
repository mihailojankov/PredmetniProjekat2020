import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {FormBuilder} from '@angular/forms';
import {IshodIspita} from '../../Models/ishod-ispita';

@Component({
  selector: 'app-ishod-ispita-dijalog',
  templateUrl: './ishod-ispita-dijalog.component.html',
  styleUrls: ['./ishod-ispita-dijalog.component.css']
})
export class IshodIspitaDijalogComponent implements OnInit {

  ishodIspitaForm;

  @Output() submitClicked = new EventEmitter<any>();

  ngOnInit() {
  }

  constructor(public dialogRef: MatDialogRef<IshodIspitaDijalogComponent>, public builder: FormBuilder) {
    this.ishodIspitaForm = builder.group({
      id: 0,
      prviKolokvijumBodovi: 0,
      drugiKolokvijumBodovi: 0,
      zavrsniIspitBodovi: 0,
      polozen: false,
      student: null,
      predmet: null
    }as IshodIspita);
  }

  dodajIshod(ishodIspita) {
    this.submitClicked.emit(ishodIspita);
    this.closeDialog();
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
