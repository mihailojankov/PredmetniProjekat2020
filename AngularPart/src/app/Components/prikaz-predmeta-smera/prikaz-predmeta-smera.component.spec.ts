import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazPredmetaSmeraComponent } from './prikaz-predmeta-smera.component';

describe('PrikazPredmetaSmeraComponent', () => {
  let component: PrikazPredmetaSmeraComponent;
  let fixture: ComponentFixture<PrikazPredmetaSmeraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazPredmetaSmeraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazPredmetaSmeraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
