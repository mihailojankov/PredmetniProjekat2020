import { TestBed } from '@angular/core/testing';

import { ClanAdministrativnogOsobljaService } from './clan-administrativnog-osoblja.service';

describe('ClanAdministrativnogOsobljaService', () => {
  let service: ClanAdministrativnogOsobljaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClanAdministrativnogOsobljaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
