import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClanAdministrativnogOsobljaProfilComponent } from './clan-administrativnog-osoblja-profil.component';

describe('ClanAdministrativnogOsobljaProfilComponent', () => {
  let component: ClanAdministrativnogOsobljaProfilComponent;
  let fixture: ComponentFixture<ClanAdministrativnogOsobljaProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClanAdministrativnogOsobljaProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClanAdministrativnogOsobljaProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
