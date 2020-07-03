import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IshodIspitaDijalogComponent } from './ishod-ispita-dijalog.component';

describe('IshodIspitaDijalogComponent', () => {
  let component: IshodIspitaDijalogComponent;
  let fixture: ComponentFixture<IshodIspitaDijalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IshodIspitaDijalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IshodIspitaDijalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
