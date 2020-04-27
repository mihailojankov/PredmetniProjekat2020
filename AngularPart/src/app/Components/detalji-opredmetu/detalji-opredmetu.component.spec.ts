import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetaljiOPredmetuComponent } from './detalji-opredmetu.component';

describe('DetaljiOPredmetuComponent', () => {
  let component: DetaljiOPredmetuComponent;
  let fixture: ComponentFixture<DetaljiOPredmetuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetaljiOPredmetuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetaljiOPredmetuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
