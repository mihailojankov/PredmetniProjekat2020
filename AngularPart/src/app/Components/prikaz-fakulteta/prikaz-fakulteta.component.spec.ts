import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazFakultetaComponent } from './prikaz-fakulteta.component';

describe('PrikazFakultetaComponent', () => {
  let component: PrikazFakultetaComponent;
  let fixture: ComponentFixture<PrikazFakultetaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazFakultetaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazFakultetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
