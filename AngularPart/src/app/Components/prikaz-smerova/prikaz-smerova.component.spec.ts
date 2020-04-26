import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazSmerovaComponent } from './prikaz-smerova.component';

describe('PrikazSmerovaComponent', () => {
  let component: PrikazSmerovaComponent;
  let fixture: ComponentFixture<PrikazSmerovaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazSmerovaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazSmerovaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
